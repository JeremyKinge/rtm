package com.kingge.rtm.controller;

import com.kingge.rtm.entity.RepCode;
import com.kingge.rtm.pojo.TKMessage;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rtm")
public class RtmControllre {


    @PostMapping("check")
    public Object check(@RequestBody TKMessage req) {
        RepCode rsp = new RepCode();
        //测试rtm系统
        System.out.println("获得回查消息是：" + req);
        if( "1".equals(req.getMsgContent()) ){//执行业务成功
            rsp.setCode(10004);
            rsp.setMessage("处理业务成功，可以发送消息到mq");
        }else if("2".equals(req.getMsgContent())){//执行业务失败
            rsp.setCode(10005);
            rsp.setMessage("处理业务失败，可以删除半消息");
        }else{//未知状态
            rsp.setCode(100065);
            rsp.setMessage("未知业务状态。。。100065");
        }
        return rsp;
    }

}
