package com.kingge.rtm.pcm.tasks;

import com.kingge.rtm.pcm.service.impl.BackToCheckService;
import com.kingge.rtm.pcm.service.impl.MessageResendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @description: 检查当前是否需要重新投递到mq
 * @author: JeremyKing
 * @create: 2020-04-27 11:59
 * @param:
 **/
@Slf4j
@Component
public class CheckResendMsgTimer {


    @Resource
    MessageResendService messageResendService;

    @Scheduled(cron = "0 */1 * * * ? ")//每隔1分钟执行一次
    public void execute() {
        log.info("【CheckResendMsgTimer】 start execute。。。。");
        messageResendService.whetherResendMessage();
        log.info("【CheckResendMsgTimer】end execute 。。。。 " );
    }


}
