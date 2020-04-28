package com.kingge.rtm.exception;

import com.kingge.rtm.constant.RtmCode;
import com.kingge.rtm.constant.ShopCode;
import lombok.extern.slf4j.Slf4j;

/**
 * 异常抛出类
 */
@Slf4j
public class CastException {
    public static void cast(RtmCode rtmCode) {
        log.error(rtmCode.toString());
        throw new CustomerException(rtmCode);
    }
}
