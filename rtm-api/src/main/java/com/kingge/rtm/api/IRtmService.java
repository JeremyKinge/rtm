package com.kingge.rtm.api;

import com.kingge.rtm.pojo.TKMessage;

/**
 * @program: rtm
 * @description: rtm暴露接口，提供上下游服务调用
 * @author: JeremyKing
 * @create: 2020-04-27 11:26
 **/
public interface IRtmService {

     /**
     * @Description: 创建半消息
     * @Param: 消息实体
     * @return: 消息id
     * @Author: JeremyKing
     * @Date: 2020/4/27 0027
     */
     public String addHalfMessage(TKMessage message);


     /**
     * @Description: 根据消息id，确认并发送半消息到mq
     * @Param: 消息id
     * @return: void
     * @Author: JeremyKing
     * @Date: 2020/4/27 0027
     */
     public void submitAndSendHalfMessage(String msg_id);


     /**
      * @Description: 根据消息id，确认消费消息
      * @Param: 消息id
      * @return: void
      * @Author: JeremyKing
      * @Date: 2020/4/27 0027
      */
     public void confirmConsumeMessage(String msg_id);

}
