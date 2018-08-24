package com.xdl.repository;

import com.xdl.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 订单
 *
 * @author xdl
 * @date 2018.08.18
 */
public interface OrderMasterDao extends JpaRepository<OrderMaster, String> {

    /**
     * 根据买家openid查找所有订单
     *
     * @param buyerOpenId
     * @param pageable
     * @return
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenId, Pageable pageable);
}
