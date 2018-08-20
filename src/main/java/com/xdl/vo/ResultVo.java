package com.xdl.vo;

import lombok.Data;

/**
 * http请求返回对象
 *
 * @author xdl
 * @date 2018.08.18
 */
@Data
public class ResultVo<T> {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;

}
