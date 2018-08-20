package com.xdl.exception;

import com.xdl.enums.ResultEnum;

/**
 * 异常
 *
 * @author xdl
 * @date 2018-08-20
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);

        this.code = code;
    }
}
