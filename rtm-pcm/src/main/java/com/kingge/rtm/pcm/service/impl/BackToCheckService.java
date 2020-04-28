package com.kingge.rtm.pcm.service.impl;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.http.HttpException;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kingge.rtm.api.IRtmService;
import com.kingge.rtm.constant.Constants;
import com.kingge.rtm.constant.RtmCode;
import com.kingge.rtm.mapper.TKDeadMessageMapper;
import com.kingge.rtm.mapper.TKMessageMapper;
import com.kingge.rtm.pcm.config.BackToCheckConfig;
import com.kingge.rtm.pcm.config.MessageResendConfig;
import com.kingge.rtm.pojo.TKDeadMessage;
import com.kingge.rtm.pojo.TKMessage;
import com.kingge.rtm.pojo.TKMessageExample;
import com.kingge.rtm.utils.DateUtil;
import com.kingge.rtm.utils.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description: 回查上游服务类
 * @author: JeremyKing
 * @create: 2020-04-27 11:59
 * @param:
 **/

@Slf4j
@Component
//@Service
public class BackToCheckService {

    @Resource
    TKMessageMapper tkMessageMapper;
    @Resource
    TKDeadMessageMapper tkDeadMessageMapper;

    @Reference
    IRtmService IRtmService;

    @Resource
    BackToCheckConfig backToCheckConfig;

    @Autowired
    private ThreadPoolExecutor backToCheckExecutor;



    /**
     * 处理所有未确认的半消息
     * @return
     */
    public int handlerAllUnconfirmedMsg(){

        // 1.半消息从创建到现在已经过了设定的超时时间，那么就需要回查
        //Constants.MSG_CHECK_DURATION 默认半消息过了14s后就需要回查
        LocalDateTime checktime = LocalDateTime.now().minus(Long.parseLong(Constants.MSG_CHECK_DURATION),
                ChronoUnit.MILLIS);
        String dateStr = checktime.format(DateTimeFormatter.ofPattern(DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS));

        //2.拼接查询参数
        TKMessageExample param = new TKMessageExample();
        param.createCriteria().andMsgStatusEqualTo(Constants.MSG_STATUS_WAIT_CONFIRM)//待确认消息
                              .andCreateMsgTimeLessThanOrEqualTo(DateUtil.strToDate(dateStr,
                                      DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS));
//        param.setOrderByClause("create_msg_time");

        //3.分页查询
        int pageSize = backToCheckConfig.getCorePoolSize();//每次取的数据满足最小线程池个数
        boolean countFlag = true;
        int totalPage = 0;//总页数退出循环条件
        int pageNum = 1;//默认获取第一页
        while(true){
            Page<TKMessage> pageResult = PageHelper.startPage(pageNum, pageSize, countFlag).setOrderBy("create_msg_time");
            tkMessageMapper.pageByExample(param);
            //遍历需要回查的消息
            for (TKMessage msg : pageResult.getResult()){
                //调用线程回查上游系统
                try {
                    backToCheckExecutor.execute( () -> backToCheckMesage(msg) );
                } catch (RejectedExecutionException e) {
                    log.error("【BackToCheckTimer】Thread pool exhaustion:" + e.getMessage());
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

        awaitComplete();

        return  pageNum*pageSize;
    }

    /**
    * @Description: 根据消息的回查地址和回查超时时间，进行回查上游系统确认半消息状态
    * @Param: 消息
    * @return: 
    * @Author: JeremyKing
    * @Date: 2020/4/28 0028
    */
    private void backToCheckMesage(TKMessage message) {
        try {
            log.info("【BackToCheckTimer】 begin call service , param-message={}", JSONUtil.toJsonStr(message));
            // 调用上游服务提供的http接口，确认半消息确认投递还是删除
            String responseResult = HttpUtil.post(message.getCheckUrl(), message.getMsgContent(), Integer.parseInt(message.getCheckTimeout()));
            log.info("【BackToCheckTimer】Http call success, messageId={}, responseResult={}", message.getMsgId(), responseResult);

            // 1.解析上游服务返回结果
            JSONObject jsonObject = JSONUtil.parseObj(responseResult);//上游服务返回的结果中有四个值：
//            Integer code;   //调用状态码
//            String message; //如果调用成功或者失败详情原因
//            String result;  //结果值

            Integer code = jsonObject.getInt("code");
            String msg = jsonObject.getStr("message");
            String result = jsonObject.getStr("result");
            if (code.equals(RtmCode.RTM_BUSINESS_STATUS_SUCCESS.getCode())) {//1.1 上游处理业务成功，需要确认投递半消息
                log.info("【BackToCheckTimer】message need to confirm and send , messageId={}", message.getMsgId());
                IRtmService.submitAndSendHalfMessage(message.getMsgId());
            } else if (code.equals(RtmCode.RTM_BUSINESS_STATUS_FAIL.getCode())) {//1.2 上游处理业务失败，删除半消息
                log.info("【BackToCheckTimer】message delete, messageId={}, failMessage={}", message.getMsgId(), message);
                tkMessageMapper.deleteByPrimaryKey(message.getMsgId());
            }else {//未知状态码
                log.error("【BackToCheckTimer】check fail, unknown-status-code , messageId={}, code={}, msg={}", message.getMsgId(), code, msg);
            }
        } catch (HttpException e) {
            log.error("【BackToCheckTimer】HttpException,call service fail, messageId=" + message.getMsgId() + ", error:", e);
        } catch (Exception e) {
            log.error("【BackToCheckTimer】Exception, messageId=" + message.getMsgId() + ", error:", e);
        }

    }

//    /**
//     * 等待所有线程执行完成
//     */
    private void awaitComplete() {
        try {
            log.info("【BackToCheckTimer】start wait all thread complete");
            int checkInterval = 1000;
            int maxCheckCount = backToCheckConfig.getWaitCompleteTimeout() / checkInterval;
            int count = 0;
            while (count < maxCheckCount) {
                log.info("【BackToCheckTimer】activeThreadCount=" + backToCheckExecutor.getActiveCount());
                if (0 == backToCheckExecutor.getActiveCount()) {
                    break;
                }
                ThreadUtil.sleep(checkInterval);
                count++;
            }
            log.info("【BackToCheckTimer】all thread completed");
        } catch (Exception e) {
            log.error("【BackToCheckTimer】WaitComplete Exception:", e);
        }
    }


}
