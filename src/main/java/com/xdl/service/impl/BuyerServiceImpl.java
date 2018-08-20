package com.xdl.service.impl;

import com.xdl.dto.OrderDto;
import com.xdl.enums.ResultEnum;
import com.xdl.exception.SellException;
import com.xdl.service.IBuyerService;
import com.xdl.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 买家
 *
 * @author xdl
 * @date 2018-08-20
 */
@Service
@Slf4j
public class BuyerServiceImpl implements IBuyerService {

    @Autowired
    private IOrderService orderService;

    @Override
    public OrderDto findOrderOne(String openid, String orderId) {
        OrderDto orderDto = orderService.findOne(orderId);
        if (orderDto == null) {
            return null;
        }

        return checkOrderOwner(orderDto, openid);
    }

    @Override
    public OrderDto cancelOrder(String openid, String orderId) {
        OrderDto orderDto = orderService.findOne(orderId);
        if (orderDto == null) {
            log.error("【取消订单】该订单不存在，orderId={}", orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        return orderService.cancel(orderDto);
    }

    /**
     * 检查订单是否属于当前用户
     *
     * @param orderDto
     * @param openid
     * @return
     */
    private OrderDto checkOrderOwner(OrderDto orderDto, String openid) {
        if (!orderDto.getBuyerOpenid().equals(openid)) {
            log.error("【查询订单】订单的openid不一致，openid={}，orderDto={}", openid, orderDto);
        }
        return orderDto;
    }

}
