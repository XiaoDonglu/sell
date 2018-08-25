package com.xdl.service;

import com.xdl.entity.SellerInfo;

/**
 * 卖家
 *
 * @author xdl
 * @date 2018-08-25
 */
public interface SellerService {

    /**
     * 通过username查询卖家信息
     *
     * @param username
     * @return
     */
    SellerInfo findSellerInfoByUsername(String username);

}
