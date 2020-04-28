package com.kingge.rtm.pcm.service.impl;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kingge.rtm.api.IKafkaService;
import com.kingge.rtm.api.IRtmService;
import com.kingge.rtm.constant.Constants;
import com.kingge.rtm.mapper.TKDeadMessageMapper;
import com.kingge.rtm.mapper.TKMessageMapper;
import com.kingge.rtm.pcm.config.MessageResendConfig;
import com.kingge.rtm.pojo.TKMessage;
import com.kingge.rtm.pojo.TKMessageExample;
import com.kingge.rtm.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description: 检查消息是否重发服务类
 * @author: JeremyKing
 * @create: 2020-04-27 11:59
 * @param:
 **/

@Slf4j
@Component
//@Service
public class MessageResendService {

    @Resource
    TKMessageMapper tkMessageMapper;

    @Reference
    IKafkaService iKafkaService;

    @Resource
    MessageResendConfig  messageResendConfig;

    @Autowired
    private ThreadPoolExecutor messageResendExecutor;

    
    /**
    * @Description: 检查是否需要重新发送消息到mq
    * @Param: 
    * @return: 
    * @Author: JeremyKing
    * @Date: 2020/4/28 0028
    */
    public void  whetherResendMessage(){

        //1.根据已经重发次数大到小进行处理需要重发的消息,优先处理快要达到最大重试次数的消息。
        int maxRetryCounts = messageResendConfig.getInterval().size();//根据时间间隔获取最大的重发次数
        for (int retryNum = maxRetryCounts-1; retryNum >= 0 ; retryNum--) {
             resend(retryNum);
        }
        awaitComplete();//查看运行过程中线程数量
    }

    /**
    * @Description: 根据重试次数和未被确认消费状态进行查询消息
    * @Param: retryNum 重试次数
    * @return: 
    * @Author: JeremyKing
    * @Date: 2020/4/28 0028
    */
    private void resend(int retryNum) {

        TKMessageExample queryParam = getQueryParam(retryNum);

        //3.分页查询
        int pageSize = messageResendConfig.getCorePoolSize();//每次取的数据满足最小线程池个数
        boolean countFlag = true;
        int totalPage = 0;//总页数退出循环条件
        int pageNum = 1;//默认获取第一页
        while(true){
            Page<TKMessage> pageResult = PageHelper.startPage(pageNum, pageSize, countFlag).setOrderBy("confirm_msg_time");
            tkMessageMapper.pageByExample(queryParam);
            //遍历需要重发到mq的消息
            for (TKMessage msg : pageResult.getResult()){
                //调用线程池重发消息到mq
                try {
                    messageResendExecutor.execute( () -> resendMesage(msg) );
                } catch (RejectedExecutionException e) {//必须处理异常，否则会影响后面的线程执行
                    log.error("【 CheckResendMsgTimer 】Thread pool exhaustion:" + e.getMessage());
                }
            }
            if (countFlag) {//不是首页，那么就不需要获取总页数了
                countFlag = false;
                totalPage = pageResult.getPages();
            }
            if (pageNum >= totalPage) {//当前读取页数等于总页数，数据读取完毕，退出循环
                break;
            }

            pageNum++;
        }


    }

    /**
    * @Description: 重发消息到mq
    * @Param: 
    * @return: 
    * @Author: JeremyKing
    * @Date: 2020/4/28 0028
    */
    private void resendMesage(TKMessage msg) {
        try {
            log.info("【 CheckResendMsgTimer 】 resend message ={}", JSONUtil.toJsonStr(msg));

            iKafkaService.sendMessage(msg);

        } catch (Exception e) {
            log.error("【 CheckResendMsgTimer 】call resendMesage()  Exception, messageId=" + msg.getMsgId() + ", error:", e);
        }
    }
    
    /**
    * @Description: 封装查询参数
    * @Param:  重试次数
    * @return: 
    * @Author: JeremyKing
    * @Date: 2020/4/28 0028
    */
    private TKMessageExample getQueryParam(int retryNum) {

        LocalDateTime checktime = LocalDateTime.now().minusMinutes(getResendInterval(retryNum));
        String dateStr = checktime.format(DateTimeFormatter.ofPattern(DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS));

        //2.拼接查询参数
        TKMessageExample param = new TKMessageExample();
        param.createCriteria().andMsgStatusEqualTo(Constants.MSG_STATUS_SENDING)//待确认消费的消息
                .andCreateMsgTimeLessThanOrEqualTo(DateUtil.strToDate(dateStr,
                        DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS))//这个值很关键，避免消息在没有到时间间隔时就被定时器检查
                                                                        //好处就是，避免刚发送到mq的消息，直接略过检查，避免此刻重复发送。
                .andMsgDStatusEqualTo(Constants.MSG_DEAD_STATUS_NORMAL)//未死亡的消息
                .andRetryCountsEqualTo(retryNum+"");//重试次数等于当前的值

        return param;
    }

    /**
    * @Description: 获取某个重发次数的重发时间间隔
    * @Param: retryNum 重发次数
    * @return: 
    * @Author: JeremyKing
    * @Date: 2020/4/28 0028
    */
    private long getResendInterval(int retryNum) {
        long result = 0L;
        List<Long> interval = messageResendConfig.getInterval();
        for (int i = 0; i <= retryNum; i++) {
            result += interval.get(i);
        }
        return result;
    }

    /**
     * 等待所有线程执行完成
     */
//    getActiveCount()
//    Returns the approximate number of threads that are actively executing tasks.
    private void awaitComplete() {
        try {
            log.info("【CheckResendMsgTimer】start wait all thread complete");
            int checkInterval = 1000;
            int maxCheckCount = messageResendConfig.getWaitCompleteTimeout() / checkInterval;
            int count = 0;
            while (count < maxCheckCount) {
                log.info("【CheckResendMsgTimer】activeThreadCount=" + messageResendExecutor.getActiveCount());
                if (0 == messageResendExecutor.getActiveCount()) {//需要注意getActiveCount方法，只是返回一个近似的正在执行任务的线程数量。如果等于0。
                    // 说明线程池中已经没有线程执行。
                    break;
                }
                ThreadUtil.sleep(checkInterval);//所以为了得到正确的正在执行的线程数量，我们需要让主线程稍微等一会。
                count++;
            }
            log.info("【CheckResendMsgTimer】all thread completed");
        } catch (Exception e) {
            log.error("【CheckResendMsgTimer】WaitComplete Exception:", e);
        }
    }
}
