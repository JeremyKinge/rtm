package com.kingge.rtm.constant;

/**
 * @author jk
 */

public enum RtmCode {

    //消息正在处理
    RTM_MQ_MESSAGE_STATUS_PROCESSING(true, 0, "消息正在处理"),
    //消息处理成功
    RTM_MQ_MESSAGE_STATUS_SUCCESS(true, 1, "消息处理成功"),
    //消息处理失败
    RTM_MQ_MESSAGE_STATUS_FAIL(false, 2, "消息处理失败"),
    //请求参数有误
    RTM_REQUEST_PARAMETER_VALID(false, -1, "请求参数有误"),
    //请求参数消息id为空
    RTM_REQUEST_MSGID_VALID(false, -11, "消息id为空"),

    //获取消息为空
    RTM_GET_MSG_EMPTY(false, -12, "获取消息为空"),

    //Topic不能为空
    RTM_MQ_TOPIC_IS_EMPTY(false, 10001, "Topic不能为空"),
    //消息体不能为空
    RTM_MQ_MESSAGE_BODY_IS_EMPTY(false, 10002, "消息体不能为空"),
    //消息体不能为空
    RTM_MQ_CHECK_URL_IS_EMPTY(false, 10003, "消息回查业务地址不能为空"),
    //上游业务处理成功
    RTM_BUSINESS_STATUS_SUCCESS(true, 10004, "上游业务处理成功"),
    //上游业务处理失败
    RTM_BUSINESS_STATUS_FAIL(true, 10005, "上游业务处理失败");

    Boolean success;
    Integer code;
    String message;

    RtmCode() {

    }

    RtmCode(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ShopCode{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
