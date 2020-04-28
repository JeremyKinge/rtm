package com.kingge.rtm.pcm.service.impl;

import com.kingge.rtm.constant.Constants;
import com.kingge.rtm.mapper.TKDeadMessageMapper;
import com.kingge.rtm.mapper.TKMessageConsumedMapper;
import com.kingge.rtm.mapper.TKMessageMapper;
import com.kingge.rtm.pcm.config.MessageResendConfig;
import com.kingge.rtm.pojo.TKDeadMessage;
import com.kingge.rtm.pojo.TKMessage;
import com.kingge.rtm.pojo.TKMessageConsumed;
import com.kingge.rtm.pojo.TKMessageExample;
import com.kingge.rtm.utils.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @description: 获取已经死亡的消息，转移到死亡消息表
 * @author: JeremyKing
 * @create: 2020-04-27 11:59
 * @param:
 **/

@Slf4j
@Component
//@Service
public class CheckDeadService {

    @Resource
    TKMessageMapper tkMessageMapper;
    @Resource
    TKDeadMessageMapper tkDeadMessageMapper;

    @Resource
    MessageResendConfig messageResendConfig;


    /**
     * 如果rtm系统重发到mq的消息，超过了重发次数，那么就会移除到死亡消息表
     * @return
     */
    public int removeAndMoveDeadMsg(){

        //1.获取消息最大重发次数，跟重发时间间隔个数有关
       int retryCounts =  messageResendConfig.getInterval().size();

        //2.查询已经超过重试次数的消息
        TKMessageExample tkMessageExample = new TKMessageExample();
        tkMessageExample.createCriteria().andMsgDStatusEqualTo(Constants.MSG_DEAD_STATUS_NORMAL)
                                         .andRetryCountsGreaterThanOrEqualTo(retryCounts+"");
        List<TKMessage> tkMessageList = tkMessageMapper.selectByExample(tkMessageExample);
        for (TKMessage msg : tkMessageList){
            //1.1 将消息转移到死亡消息表
            String encode = JSON.encode(msg);
            TKDeadMessage decode = JSON.decode(encode, TKDeadMessage.class);
            decode.setMsgDStatus(Constants.MSG_DEAD_STATUS_DEAD);
            decode.setUpdateMsgTime(new Date());
            tkDeadMessageMapper.insertSelective(decode);
            //1.2 从消息表中删除当前消息
            tkMessageMapper.deleteByPrimaryKey(msg.getMsgId());
        }
        return tkMessageList.size();
    }


}
