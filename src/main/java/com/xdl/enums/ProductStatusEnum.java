package com.xdl.enums;

import lombok.Getter;

/**
 * 商品状态
 *
 * @author xdl
 * @date 2018-08-18
 */
@Getter
public enum ProductStatusEnum implements CodeEnum {

    //上架
    UP(0),

    //下架
    DOWN(1);

    private Integer code;

    ProductStatusEnum(Integer code) {
        this.code = code;
    }
}
