//package com.kingge.rtm.mq;
//
//import org.springframework.cloud.stream.annotation.Input;
//import org.springframework.cloud.stream.annotation.Output;
//import org.springframework.messaging.SubscribableChannel;
//
///**
// * @program: rtm
// * @description: 配置消息通道
// * @author: JeremyKing
// * @create: 2020-04-27 17:33
// **/
//public class MessageChannel {
//
//    /**
//     * 发消息的通道名称
//     */
//    String DEMO_OUTPUT = "demo_output";
//    /**
//     * 消息的订阅通道名称
//     */
//    String DEMO_INPUT = "demo_input";
//    /**
//     * 发消息的通道
//     *
//     * @return
//     */
//    @Output(DEMO_OUTPUT)
//    MessageChannel sendDemoMessage();
//    /**
//     * 收消息的通道
//     *
//     * @return
//     */
//    @Input(DEMO_INPUT)
//    SubscribableChannel recieveDemoMessage();
//}
