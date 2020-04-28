package com.kingge.rtm.pcm.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>Title:</p>
 * <p>Description:
 * 消息确认定时任务配置
 * </p>
 *
 * @author Chen Nan
 * @date 2019/3/18.
 */
@Component
@ConfigurationProperties(prefix = "timertaskconfig.backtocheck")
@Data
public class BackToCheckConfig {
    /**
     * 线程池最小线程数
     */
    private Integer corePoolSize = 10;
    /**
     * 线程池最大线程数
     */
    private Integer maximumPoolSize = 100;
    /**
     * 线程运行的空闲时间
     */
    private Integer keepAliveTime = 60000;
    /**
     * 缓存队列大小
     */
    private Integer queueCapacity = 10;
    /**
     * 等待所有线程执行完成的超时时间（单位：毫秒），
     * 因为确认超时时间最长为5秒(因为rtm-mlm的消息确认接口，默认超时是Constants.SERVICE_CALL_TIME_OUT 5s)
     * 因此此处超时时间建议设置大于5秒，则足够所有线程完成。
     */
    private Integer waitCompleteTimeout = 10000;
}
