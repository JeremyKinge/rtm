package com.kingge.rtm.servicetest;

import com.kingge.rtm.RtmServiceApplication;
import com.kingge.rtm.api.IRtmService;
import com.kingge.rtm.pojo.TKMessage;
import com.kingge.rtm.utils.JSON;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RtmServiceApplication.class)
public class OrderServiceTest {
    @Autowired
    IRtmService IRtmService;

    @Test
    public void addHalfMessage() throws IOException {
        System.out.println("开始发送消息。。。。");
        for (int i =1; i <= 20; i++){
            int flag = i%2 ==0 ? 1: 2;
            TKMessage TKMessage = new TKMessage();
            TKMessage.setTopic("demo");
            TKMessage.setCheckUrl("http://127.0.0.1:10010/rtm/check");
            TKMessage.setMsgContent(flag+"");
            TKMessage.setMsgContent(JSON.encode(TKMessage));
            IRtmService.addHalfMessage(TKMessage);
        }
        System.out.println("开始发送消息。。。。");
//        System.in.read();

    }

    @Test
    public void submitAndSendHalfMessage() throws IOException {
        System.out.println("确认发送消息。。。。");
        IRtmService.submitAndSendHalfMessage("a56c26e992a54047976e24025d2a815f");
        System.out.println("确认发送消息。。。。");
//        System.in.read();

    }


    @Test
    public void confirmConsumeMessage() throws IOException {
        System.out.println("确认消费消息。。。。");
        IRtmService.confirmConsumeMessage("a56c26e992a54047976e24025d2a815f");
        System.out.println("确认消费消息。。。。");
//        System.in.read();

    }



}
