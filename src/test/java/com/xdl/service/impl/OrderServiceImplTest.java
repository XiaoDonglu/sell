package com.xdl.service.impl;

import com.xdl.dto.OrderDto;
import com.xdl.enums.OrderStatusEnum;
import com.xdl.enums.PayStatusEnum;
import com.xdl.model.OrderDetail;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单
 *
 * @author xdl
 * @date 2018-08-18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID = "1101110";

    private final String ORDER_ID = "1534736282303975345";

    @Test
    public void create() throws Exception {

        OrderDto orderDto = new OrderDto();
        orderDto.setBuyerName("xdl");
        orderDto.setBuyerAddress("hfmx");
        orderDto.setBuyerPhone("123456789012");
        orderDto.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("092401");
        o1.setProductQuantity(1);

        OrderDetail o2 = new OrderDetail();
        o2.setProductId("092501");
        o2.setProductQuantity(2);

        orderDetailList.add(o1);
        orderDetailList.add(o2);

        orderDto.setOrderDetailList(orderDetailList);

        OrderDto result = orderService.create(orderDto);
        log.info("【创建订单】result={}", result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() throws Exception {
        OrderDto result = orderService.findOne(ORDER_ID);
        log.info("【查询单个订单】result={}", result);
        Assert.assertEquals(ORDER_ID, result.getOrderId());
    }

    @Test
    public void findList() throws Exception {
        PageRequest request = new PageRequest(0, 2);
        Page<OrderDto> orderDtoPage = orderService.findList(BUYER_OPENID, request);
        Assert.assertNotEquals(0, orderDtoPage.getTotalElements());
    }

    @Test
    public void cancel() throws Exception {
        OrderDto orderDto = orderService.findOne(ORDER_ID);
        OrderDto result = orderService.cancel(orderDto);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());
    }

    @Test
    public void finish() throws Exception {
        OrderDto orderDto = orderService.findOne(ORDER_ID);
        OrderDto result = orderService.finish(orderDto);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(), result.getOrderStatus());
    }

    @Test
    public void paid() throws Exception {
        OrderDto orderDto = orderService.findOne(ORDER_ID);
        OrderDto result = orderService.paid(orderDto);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
    }

    @Test
    public void list() {
        PageRequest request = PageRequest.of(0, 2);
        Page<OrderDto> orderDtoPage = orderService.findList(request);
//        Assert.assertNotEquals(0, orderDtoPage.getTotalElements());
        Assert.assertTrue("查询所有的订单列表", orderDtoPage.getTotalElements() > 0);
    }

}