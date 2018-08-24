package com.xdl.service;

import com.xdl.dto.OrderDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 订单
 *
 * @author xdl
 * @date 2018-08-20
 */
public interface OrderService {

    /**
     * 创建订单
     *
     * @param orderDto
     * @return
     */
    OrderDto create(OrderDto orderDto);

    /**
     * 查询单个订单
     *
     * @param orderId
     * @return
     */
    OrderDto findOne(String orderId);

    /**
     * 查询订单列表
     *
     * @param buyerOpenid
     * @param pageable
     * @return
     */
    Page<OrderDto> findList(String buyerOpenid, Pageable pageable);

    /**
     * 取消订单
     *
     * @param orderDto
     * @return
     */
    OrderDto cancel(OrderDto orderDto);

    /**
     * 完结订单
     *
     * @param orderDto
     * @return
     */
    OrderDto finish(OrderDto orderDto);

    /**
     * 支付订单
     *
     * @param orderDto
     * @return
     */
    OrderDto paid(OrderDto orderDto);

    /**
     * 查询订单列表
     *
     * @param pageable
     * @return
     */
    Page<OrderDto> findList(Pageable pageable);

}
