package com.kingge.rtm.pcm.tasks;

import com.kingge.rtm.pcm.service.impl.BackToCheckService;
import com.kingge.rtm.pcm.service.impl.CheckDeadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @description: 向上游服务回查，当前半消息是否确认投递还是删除。
 * @author: JeremyKing
 * @create: 2020-04-27 11:59
 * @param:
 **/
@Slf4j
@Component
public class BackToCheckTimer {


    @Resource
    BackToCheckService backToCheckService;

    @Scheduled(cron = "0 */1 * * * ? ")//每隔两分钟执行一次
    public void execute() {
        log.info("【BackToCheckTimer】开始执行。。。。");
//        System.out.println("【BackToCheckTimer】开始执行。。。。");
        int size = backToCheckService.handlerAllUnconfirmedMsg();
//        System.out.println("【BackToCheckTimer】执行结束。。。。");
        log.info("【BackToCheckTimer】执行结束。。。。 " );
    }


}
