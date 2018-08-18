package com.xdl.dao;

import com.xdl.model.TOrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 订单
 *
 * @author xdl
 * @date 2018.08.18
 */
public interface IOrderMasterDao extends JpaRepository<TOrderMaster, String> {

    /**
     * 根据买家openId查找所有订单
     * @param buyerOpenId
     * @param pageable
     * @return
     */
    Page<TOrderMaster> findByBuyerOpenId(String buyerOpenId, Pageable pageable);
}
