package com.kingge.rtm.pcm.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description: 消息重发mq配置表
 * @author: JeremyKing
 * @create: 2020-04-27 11:59
 * @param:
 **/
@Component
@ConfigurationProperties(prefix = "timertaskconfig.resendmsg")
@Data
public class MessageResendConfig {
    /**
     * 线程池最小线程数
     */
    private Integer corePoolSize = 10;
    /**
     * 线程池最大线程数
     */
    private Integer maximumPoolSize = 100;
    /**
     * 线程运行的空闲时间 ms
     */
    private Integer keepAliveTime = 60000;
    /**
     * 缓存队列大小
     */
    private Integer queueCapacity = 10;
    /**
     * 等待所有线程执行完成的超时时间（单位：ms）
     *
     */
    private Integer waitCompleteTimeout = 10000;

    /**
     * 消息重发到mq 时间间隔（单位：分钟） - 模拟rocketmq实现
     * 举例： [1,2,4, 10, 30, 60, 120, 360]
     * 消息确认会向下游业务发送首次消息，1分钟内，下游服务没有调用rtm接口确认消费该消息，
     * 则消息会重新发送
     * 再过2分钟（也就是消息确认后3分钟内），下游业务没有确认消费该消息
     * 则消息会重新发送
     * 以此类推。。。。。
     */
    private List<Long> interval;
}
