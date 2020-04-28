package com.kingge.rtm.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.kingge.rtm.api.IRtmService;
import com.kingge.rtm.constant.Constants;
import com.kingge.rtm.constant.RtmCode;
import com.kingge.rtm.exception.CastException;
import com.kingge.rtm.mapper.TKMessageConsumedMapper;
import com.kingge.rtm.mapper.TKMessageMapper;
import com.kingge.rtm.mq.KafkaSendService;
import com.kingge.rtm.pojo.TKMessage;
import com.kingge.rtm.pojo.TKMessageConsumed;
import com.kingge.rtm.utils.JSON;
import com.kingge.rtm.utils.UUID64;
import com.kingge.rtm.utils.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * @description: rtm服务接口实现类
 * @author: JeremyKing
 * @create: 2020-04-27 11:59
 * @param: 5s内方法如果没有返回，那么就抛异常给调用者
 **/
@Component
@Service(timeout = Constants.SERVICE_CALL_TIME_OUT,interfaceClass = IRtmService.class)
@Slf4j
public class RtmServiceImpl implements IRtmService {

    @Autowired
    TKMessageMapper tkMessageMapper;
    @Autowired
    TKMessageConsumedMapper tkMessageConsumedMapper;
    @Autowired
    private KafkaSendService kafkaSendService;

    @Override
    public String addHalfMessage(TKMessage message) {

        //1.参数校验
        if(Util.isNullOrEmpty(message.getTopic())) CastException.cast(RtmCode.RTM_MQ_TOPIC_IS_EMPTY);
        if(Util.isNullOrEmpty(message.getMsgContent())) CastException.cast(RtmCode.RTM_MQ_MESSAGE_BODY_IS_EMPTY);
        if(Util.isNullOrEmpty(message.getCheckUrl())) CastException.cast(RtmCode.RTM_MQ_CHECK_URL_IS_EMPTY);
        //2.创建半消息
        message.setMsgId(UUID64.getNewUUID());
        Date date = new Date();
        message.setCreateMsgTime(date);
        message.setUpdateMsgTime(date);

        message.setMsgStatus(Constants.MSG_STATUS_WAIT_CONFIRM);
        message.setMsgDStatus(Constants.MSG_DEAD_STATUS_NORMAL);

        message.setRetryCounts(Constants.MSG_RETRY_COUNTS);

        message.setCheckTimeout(Constants.MSG_CHECK_TIMEOUT);
        message.setCheckDuration(Constants.MSG_CHECK_DURATION);

        tkMessageMapper.insertSelective(message);
        return message.getMsgId();
    }

    @Override
    public void submitAndSendHalfMessage(String msg_id) {

        //1.参数校验
        if(Util.isNullOrEmpty(msg_id))CastException.cast(RtmCode.RTM_REQUEST_MSGID_VALID);

        //2.根据消息id，查询消息
        TKMessage tkMessage = tkMessageMapper.selectByPrimaryKey(msg_id);
        if(Util.isNullOrEmpty(tkMessage))CastException.cast(RtmCode.RTM_GET_MSG_EMPTY);

        //3.更新消息为，发送中
        TKMessage uMsg = new TKMessage();
        uMsg.setMsgId(tkMessage.getMsgId());
        uMsg.setMsgStatus(Constants.MSG_STATUS_SENDING);
        uMsg.setUpdateMsgTime(new Date());
        uMsg.setConfirmMsgTime(new Date());
        tkMessageMapper.updateByPrimaryKeySelective(uMsg);

        //4.发送消息
        kafkaSendService.send(tkMessage.getTopic(),JSON.encode(tkMessage));
//        kafkaSendService.sendMsg(JSON.encode(tkMessage));

    }

    @Override
    public void confirmConsumeMessage(String msg_id) {
        //1.参数校验
        if(Util.isNullOrEmpty(msg_id))CastException.cast(RtmCode.RTM_REQUEST_MSGID_VALID);

        //2.根据消息id，查询消息
        TKMessage tkMessage = tkMessageMapper.selectByPrimaryKey(msg_id);
        if(!Util.isNullOrEmpty(tkMessage)){
            //2.1 如果消息不为空，那么将消息转移到已消费历史表中
            tkMessage.setMsgStatus(Constants.MSG_STATUS_CONSUMED);
            String encode = JSON.encode(tkMessage);
            TKMessageConsumed decode = JSON.decode(encode, TKMessageConsumed.class);
            tkMessageConsumedMapper.insertSelective(decode);

            tkMessageMapper.deleteByPrimaryKey(msg_id);
        }
    }
}
