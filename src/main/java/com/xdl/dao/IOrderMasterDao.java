package com.xdl.dao;

import com.xdl.model.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 订单
 *
 * @author xdl
 * @date 2018.08.18
 */
public interface IOrderMasterDao extends JpaRepository<OrderMaster, String> {

    /**
     * 根据买家openId查找所有订单
     * @param buyerOpenId
     * @param pageable
     * @return
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenId, Pageable pageable);
}
