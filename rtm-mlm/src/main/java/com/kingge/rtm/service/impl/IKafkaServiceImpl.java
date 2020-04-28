package com.kingge.rtm.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.kingge.rtm.api.IKafkaService;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


/**
 * @description: mq消息重发类
 * @author: JeremyKing
 * @create: 2020-04-27 11:59
 **/
@Component
@Service(interfaceClass = IKafkaService.class)
@Slf4j
public class IKafkaServiceImpl implements IKafkaService {

    @Autowired
    TKMessageMapper tkMessageMapper;
    @Autowired
    private KafkaSendService kafkaSendService;


    /**
     * @Description: 发送消息到mq
     * @Param: 待发送消息
     * @return:
     * @Author: JeremyKing
     * @Date: 2020/4/28 0028
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class) //避免重发消息到mq失败，还增加了重试次数
    public void sendMessage(TKMessage message) {

        log.info("【 sendMessage 】 call  start, messageId={}", message.getMsgId());
        // 1.消息重发次数增加1
        message.setRetryCounts( (Integer.parseInt(message.getRetryCounts())+1)+"" );
        tkMessageMapper.updateByPrimaryKeySelective(message);

        // 2.重发消息到mq
        kafkaSendService.send(message.getTopic(),JSON.encode(message));
        log.info("【 sendMessage 】success, messageId={}", message.getMsgId());
    }
}