package com.xdl.service.impl;

import com.xdl.dao.SellerInfoDao;
import com.xdl.entity.SellerInfo;
import com.xdl.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 卖家
 *
 * @author xdl
 * @date 2018-08-25
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoDao sellerInfoDao;

    @Override
    public SellerInfo findSellerInfoByUsername(String username) {
        return sellerInfoDao.findByUsername(username);
    }
}
