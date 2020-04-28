package com.kingge.rtm.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
/**
 * @program: rtm
 * @description: kafka发送消息类
 * @author: JeremyKing
 * @create: 2020-04-27 17:19
 **/
@Component
public class KafkaSendService {

    @Autowired
    private KafkaTemplate KafkaTemplate;

    public String send(String topic,String msg){
        KafkaTemplate.send(topic, msg); //使用kafka模板发送信息
        return "success";
    }
}
