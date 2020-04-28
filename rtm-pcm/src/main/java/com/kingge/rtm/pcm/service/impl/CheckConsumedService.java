package com.kingge.rtm.pcm.service.impl;

import com.kingge.rtm.constant.Constants;
import com.kingge.rtm.mapper.TKMessageConsumedMapper;
import com.kingge.rtm.mapper.TKMessageMapper;
import com.kingge.rtm.pojo.TKMessage;
import com.kingge.rtm.pojo.TKMessageConsumed;
import com.kingge.rtm.pojo.TKMessageExample;
import com.kingge.rtm.utils.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 检查消息已经消费服务
 * @author: JeremyKing
 * @create: 2020-04-27 11:59
 * @param:
 **/

@Slf4j
@Component
//@Service
public class CheckConsumedService {

    @Resource
    TKMessageMapper tkMessageMapper;
    @Resource
    TKMessageConsumedMapper tkMessageConsumedMapper;

    public int removeAndMoveConsumedMsg(){

        //1.根据消息 已经消费 状态查询所有消息
        TKMessageExample tkMessageExample = new TKMessageExample();
        tkMessageExample.createCriteria().andMsgStatusEqualTo(Constants.MSG_STATUS_CONSUMED);
        List<TKMessage> tkMessageList = tkMessageMapper.selectByExample(tkMessageExample);
        for (TKMessage msg : tkMessageList){
            //1.1 将消息转移到已经消费消息表
            String encode = JSON.encode(msg);
            TKMessageConsumed decode = JSON.decode(encode, TKMessageConsumed.class);
            tkMessageConsumedMapper.insertSelective(decode);
            //1.2 从消息表中删除当前消息
            tkMessageMapper.deleteByPrimaryKey(msg.getMsgId());
        }
        return tkMessageList.size();
    }


}
