package com.kingge.rtm.pcm.threadpool;

import cn.hutool.core.thread.ThreadFactoryBuilder;
import com.kingge.rtm.pcm.config.BackToCheckConfig;
import com.kingge.rtm.pcm.config.MessageResendConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description: 为了业务的互不干扰，这里为重发消息到mq服务和回查上游业务结果服务，各创建两个线程池。
 * @author: JeremyKing
 * @create: 2020-04-27 11:59
 * @param:
 **/
@Component
public class ThreadPool {
    @Resource
    BackToCheckConfig backToCheckConfig;
    @Resource
    MessageResendConfig messageResendConfig;

    @Bean
    public ThreadPoolExecutor backToCheckExecutor() {
        // 为线程池起名
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNamePrefix("back-to-check-pool-").build();
        return new ThreadPoolExecutor(backToCheckConfig.getCorePoolSize(),
                backToCheckConfig.getMaximumPoolSize(),
                backToCheckConfig.getKeepAliveTime(),
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(backToCheckConfig.getQueueCapacity()),
                namedThreadFactory);
    }

    @Bean
    public ThreadPoolExecutor messageResendExecutor() {
        // 为线程池起名
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNamePrefix("message-resend-pool-").build();
        return new ThreadPoolExecutor(messageResendConfig.getCorePoolSize(),
                messageResendConfig.getMaximumPoolSize(),
                messageResendConfig.getKeepAliveTime(),
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(messageResendConfig.getQueueCapacity()),
                namedThreadFactory);
    }
}
