package com.xdl.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xdl.dto.OrderDto;
import com.xdl.enums.ResultEnum;
import com.xdl.exception.SellException;
import com.xdl.form.OrderForm;
import com.xdl.entity.OrderDetail;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 订单form <-> 订单dto 转换器
 *
 * @author xdl
 * @date 2018-08-20
 */
@Slf4j
public class OrderForm2OrderDtoConverter {

    public static OrderDto convert(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDto orderDto = new OrderDto();

        orderDto.setBuyerName(orderForm.getName());
        orderDto.setBuyerPhone(orderForm.getPhone());
        orderDto.setBuyerAddress(orderForm.getAddress());
        orderDto.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList;
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {

            }.getType());
        } catch (Exception e) {
            log.error("【对象转换】错误, string={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDto.setOrderDetailList(orderDetailList);

        return orderDto;
    }
}
