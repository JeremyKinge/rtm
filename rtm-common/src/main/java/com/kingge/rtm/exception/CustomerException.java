package com.kingge.rtm.exception;


import com.kingge.rtm.constant.RtmCode;

/**
 * 自定义异常
 */
public class CustomerException extends RuntimeException{

    private RtmCode shopCode;

    public CustomerException(RtmCode shopCode) {
        this.shopCode = shopCode;
    }
}
