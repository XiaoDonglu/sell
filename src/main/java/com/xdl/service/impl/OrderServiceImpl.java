package com.xdl.service.impl;

import com.xdl.dao.IOrderDetailDao;
import com.xdl.dao.IOrderMasterDao;
import com.xdl.dto.CartDto;
import com.xdl.dto.OrderDto;
import com.xdl.enums.OrderStatusEnum;
import com.xdl.enums.PayStatusEnum;
import com.xdl.enums.ResultEnum;
import com.xdl.exception.SellException;
import com.xdl.model.OrderDetail;
import com.xdl.model.OrderMaster;
import com.xdl.model.ProductInfo;
import com.xdl.service.IOrderService;
import com.xdl.service.IProductService;
import com.xdl.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 订单
 *
 * @author: xdl
 * @date: 2018-08-20
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IProductService productService;

    @Autowired
    private IOrderDetailDao orderDetailDao;

    @Autowired
    private IOrderMasterDao orderMasterDao;

    @Override
    @Transactional
    public OrderDto create(OrderDto orderDto) {

        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        String orderId = KeyUtil.getUniqueKey();
        List<OrderDetail> orderDetailList = orderDto.getOrderDetailList();

        for (OrderDetail orderDetail : orderDetailList) {
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
            //商品不存在
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            //计算总价
            orderAmount = productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);

            //保存订单详情
            orderDetail.setOrderId(orderId);
            orderDetail.setDetailId(KeyUtil.getUniqueKey());
            orderDetail.setProductName(productInfo.getProductName());
            orderDetail.setProductPrice(productInfo.getProductPrice());
            orderDetail.setProductIcon(productInfo.getProductIcon());
            orderDetailDao.save(orderDetail);
        }

        //保存订单主表信息
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDto, orderMaster);
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterDao.save(orderMaster);

        //扣库存
        List<CartDto> cartDtoList = orderDetailList.stream().map(
                e -> new CartDto(e.getProductId(), e.getProductQuantity())
        ).collect(Collectors.toList());
        productService.decreaseStock(cartDtoList);

        return orderDto;
    }

    @Override
    public OrderDto findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDto> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDto cancel(OrderDto orderDto) {
        return null;
    }

    @Override
    public OrderDto finish(OrderDto orderDto) {
        return null;
    }

    @Override
    public OrderDto paio(OrderDto orderDto) {
        return null;
    }
}
