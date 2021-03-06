package com.xdl.enums;

import lombok.Getter;

/**
 * 支付状态
 *
 * @author xdl
 * @date 2018-08-18
 */
@Getter
public enum PayStatusEnum implements CodeEnum {

    //等待支付
    WAIT(0, "等待支付"),

    //支付成功
    SUCCESS(1, "支付成功");

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
