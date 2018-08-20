package com.xdl.dto;

import lombok.Data;

/**
 * 购物车
 *
 * @author: xdl
 * @date: 2018-08-20
 */
@Data
public class CartDto {

    /**
     * 商品id
     */
    private String productId;

    /**
     * 购物数量
     */
    private Integer productQuantity;

    public CartDto(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
