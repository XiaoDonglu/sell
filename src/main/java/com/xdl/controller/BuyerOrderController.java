package com.xdl.controller;

import com.xdl.converter.OrderForm2OrderDtoConverter;
import com.xdl.dto.OrderDto;
import com.xdl.enums.ResultEnum;
import com.xdl.exception.SellException;
import com.xdl.form.OrderForm;
import com.xdl.service.BuyerService;
import com.xdl.service.OrderService;
import com.xdl.utils.ResultVoUtil;
import com.xdl.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 买家订单
 *
 * @author xdl
 * @date 2018-08-20
 */
@RestController
@Slf4j
@RequestMapping("/buyer/order")
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerService buyerService;

    /**
     * 创建订单
     *
     * @param orderForm
     * @param bindingResult
     * @return
     */
    @PostMapping("create")
    public ResultVo<Map<String, String>> create(@Valid OrderForm orderForm,
                                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确，orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDto orderDto = OrderForm2OrderDtoConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDto.getOrderDetailList())) {
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDto createResult = orderService.create(orderDto);

        Map<String, String> map = new HashMap<>(1);
        map.put("orderId", createResult.getOrderId());

        return ResultVoUtil.success(map);
    }

    /**
     * 订单列表
     *
     * @param openid
     * @param page
     * @param size
     * @return
     */
    @GetMapping("list")
    public ResultVo<List<OrderDto>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size) {
        if (StringUtils.isEmpty(openid)) {
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        PageRequest pageRequest = PageRequest.of(page, size);
        Page<OrderDto> orderDtoPage = orderService.findList(openid, pageRequest);

        return ResultVoUtil.success(orderDtoPage.getContent());
    }

    /**
     * 商品详情
     *
     * @param openid
     * @param orderId
     * @return
     */
    @GetMapping("detail")
    public ResultVo<OrderDto> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId) {
        OrderDto orderDto = buyerService.findOrderOne(openid, orderId);
        return ResultVoUtil.success(orderDto);
    }

    /**
     * 商品详情
     *
     * @param openid
     * @param orderId
     * @return
     */
    @PostMapping("cancel")
    public ResultVo<OrderDto> cancel(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId) {
        buyerService.cancelOrder(openid, orderId);
        return ResultVoUtil.success();
    }

}
