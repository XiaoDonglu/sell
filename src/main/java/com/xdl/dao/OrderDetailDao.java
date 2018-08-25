package com.xdl.dao;

import com.xdl.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 订单详情
 *
 * @author xdl
 * @date 2018.08.18
 */
public interface OrderDetailDao extends JpaRepository<OrderDetail, String> {

    /**
     * 查询某一订单下所有详情
     *
     * @param orderId
     * @return
     */
    List<OrderDetail> findByOrderId(String orderId);
}
