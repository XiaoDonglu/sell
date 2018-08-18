package com.xdl.dao;

import com.xdl.model.TOrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 订单详情
 *
 * @author xdl
 * @date 2018.08.18
 */
public interface IOrderDetailDao extends JpaRepository<TOrderDetail, String> {

    /**
     * 查询某一订单下所有详情
     *
     * @param orderId
     * @return
     */
    List<TOrderDetail> findByOrderId(String orderId);
}
