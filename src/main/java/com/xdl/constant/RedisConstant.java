package com.xdl.constant;

/**
 * Redis常量
 *
 * @author xdl
 * @date 2018-08-25
 */
public interface RedisConstant {

    /**
     * 开头
     */
    String TOKEN_PREFIX = "token_%s";

    /**
     * 2小时
     */
    Integer EXPIRE = 7200;
}
