package com.kingge.rtm.pcm.tasks;

import com.kingge.rtm.pcm.service.impl.CheckConsumedService;
import com.kingge.rtm.pcm.service.impl.CheckDeadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @description: 检查已经死亡的消息，转移到死亡消息表中
 * @author: JeremyKing
 * @create: 2020-04-27 11:59
 * @param:
 **/
@Slf4j
@Component
public class CheckDeadTimer {


    @Resource
    CheckDeadService checkDeadService;

    @Scheduled(cron = "0 */2 * * * ? ")//每隔两分钟执行一次
    public void execute() {

        log.info("【CheckDeadTimer】 start execute开始执行。。。。");
        int size = checkDeadService.removeAndMoveDeadMsg();
        log.info("【CheckDeadTimer】 end execute 执行结束。。。。一共在操作 " + size + " 条消息");

    }


}
