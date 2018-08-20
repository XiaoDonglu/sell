package com.xdl.service;

import com.xdl.dto.OrderDto;

/**
 * 买家
 *
 * @author xdl
 * @date 2018-08-20
 */
public interface IBuyerService {

    /**
     * 查找一个订单
     *
     * @param openid
     * @param orderId
     * @return
     */
    OrderDto findOrderOne(String openid, String orderId);

    /**
     * 取消订单
     *
     * @param openid
     * @param orderId
     * @return
     */
    OrderDto cancelOrder(String openid, String orderId);

}
