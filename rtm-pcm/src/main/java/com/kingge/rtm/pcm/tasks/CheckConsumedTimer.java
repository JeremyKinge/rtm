package com.kingge.rtm.pcm.tasks;

import com.kingge.rtm.pcm.service.impl.CheckConsumedService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @description: 检查下游服务已经消费的消息，转移到消费表中
 * @author: JeremyKing
 * @create: 2020-04-27 11:59
 * @param:
 **/
@Slf4j
@Component
public class CheckConsumedTimer {


    @Resource
    CheckConsumedService checkConsumedService;

    @Scheduled(cron = "0 0 2 * * ? ")//每天凌晨两点调用
    public void execute() {
        log.info("【CheckConsumedTimer】开始执行。。。。");
//        System.out.println("【CheckConsumedTimer】开始执行。。。。");
        int size = checkConsumedService.removeAndMoveConsumedMsg();
//        System.out.println("【CheckConsumedTimer】执行结束。。。。");
        log.info("【CheckConsumedTimer】执行结束。。。。一共在操作 " + size + " 条消息");
    }


}
