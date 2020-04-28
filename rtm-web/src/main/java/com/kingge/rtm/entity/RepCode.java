package com.kingge.rtm.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Title: BaseRsp</p>
 * <p>Description: Http操作结果对象</p>
 */
@Data
public class RepCode implements Serializable {
            Integer code;   //调用状态码
            String message; //如果调用成功或者失败详情原因
            String result;  //结果值
}
