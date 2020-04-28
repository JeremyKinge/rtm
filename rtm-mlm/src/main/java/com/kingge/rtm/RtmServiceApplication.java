package com.kingge.rtm;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动消息服务，上下游系统可以开始调用
 */
@SpringBootApplication
@EnableDubbo
public class RtmServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RtmServiceApplication.class,args);
    }


}
