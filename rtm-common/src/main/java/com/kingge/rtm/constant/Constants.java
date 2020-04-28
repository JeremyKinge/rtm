package com.kingge.rtm.constant;


/**
* @Description: rtm系统常量类
* @Author: JeremyKing
* @Date: 2020/4/27 0027
*/
public class Constants {


    /**
     * dubbo服务超时时长，单位s
     */
    public static final int SERVICE_CALL_TIME_OUT = 5000;


    /**
     * 消息状态，0-待确认，1-已确认发送中，2-已消费
     */
    public static  String  MSG_STATUS_WAIT_CONFIRM = "0";
    public static  String  MSG_STATUS_SENDING = "1";
    public static  String  MSG_STATUS_CONSUMED = "2";

    /**
     * 消息是否死亡，0-正常，1-已死亡
     */
    public static  String  MSG_DEAD_STATUS_NORMAL= "0";
    public static  String  MSG_DEAD_STATUS_DEAD = "1";

    /**
     * 消息初始化重试次数 0
     */
    public static  String  MSG_RETRY_COUNTS= "0";

    /**
     * 消息回查初始化参数 单位ms
     *  check_timeout        varchar(10) comment '消息回查超时时间',
     *   check_duration       varchar(10) comment '消息回查周期时间，消息未确认时在这时间内需要回查',
     */
    public static  String  MSG_CHECK_TIMEOUT= "4000"; //4s
    public static  String  MSG_CHECK_DURATION= "10000";//10s

//
//    /* 通用应答码 URC-Universal Response Code */
//    /**
//     * 应答码：成功
//     */
//    public static final int CODE_SUCCESS = 0;
//    /**
//     * 应答码：失败
//     */
//    public static final int CODE_FAILURE = 1;
//
//    /**
//     * key
//     */
//    public static final String KEY_CODE = "code";
//    public static final String KEY_MSG = "msg";
//    public static final String KEY_DATA = "data";
//    public static final String KEY_PAGE_NUM = "pageNum";
//    public static final String KEY_PAGE_SIZE = "pageSize";
//    public static final String KEY_COUNT = "count";
//    public static final String KEY_ORDER_BY = "orderBy";
//
//    /**
//     * OrderBy
//     */
//    public static final String ORDER_BY_CREATE_TIME = "create_time";
//    public static final String ORDER_BY_CONFIRM_TIME = "confirm_time";
//
//    /**
//     * 用户session
//     */
//    public static final String SESSION_USER = "session_user";
//
//    /**
//     * MSG
//     */
//    public static final String MSG_SUCCESS = "SUCCESS";
//    public static final String MSG_READ_CONFIG_ERROR = "读取配置文件错误";


}
