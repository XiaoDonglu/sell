package com.xdl.dao;

import com.xdl.entity.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 卖家
 *
 * @author xdl
 * @date 2018-08-25
 */
public interface SellerInfoDao extends JpaRepository<SellerInfo, String> {

    /**
     * 通过username查询卖家信息
     *
     * @param username
     * @return
     */
    SellerInfo findByUsername(String username);

}
