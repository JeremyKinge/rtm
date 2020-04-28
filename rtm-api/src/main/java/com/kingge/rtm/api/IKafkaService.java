package com.kingge.rtm.api;

import com.kingge.rtm.pojo.TKMessage;

/**
 * @program: rtm
 * @description: kafka发送消息接口类
 * @author: JeremyKing
 * @create: 2020-04-28 15:28
 **/
public interface  IKafkaService {

    /**
     * @Description: 发送消息
     * @Param: 消息实体
     * @return:
     * @Author: JeremyKing
     * @Date: 2020/4/27 0027
     */
    public void  sendMessage(TKMessage message);
}
