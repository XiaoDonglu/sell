package com.xdl.enums;

import lombok.Getter;

/**
 * 订单状态
 *
 * @author xdl
 * @date 2018-08-18
 */
@Getter
public enum OrderStatusEnum implements CodeEnum {

    //新订单
    NEW(0, "新订单"),

    //完结
    FINISHED(1, "完结"),

    //已取消
    CANCEL(2, "已取消");

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
