package com.kingge.rtm.pcm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动定时检查消息服务
 */
@SpringBootApplication
@EnableScheduling
@MapperScan("com.kingge.rtm.mapper")
@ComponentScan(basePackages = {
        "com.kingge.rtm.mapper","com.kingge.rtm.pcm"})
public class PeriodCheckMessageApplication {
    public static void main(String[] args) {
        SpringApplication.run(PeriodCheckMessageApplication.class, args);
    }
}
