package com.xdl.service.impl;

import com.xdl.dao.IProductInfoDao;
import com.xdl.enums.ProductStatusEnum;
import com.xdl.model.TProductInfo;
import com.xdl.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品
 *
 * @author xdl
 * @date 2018-08-18
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    IProductInfoDao productInfoDao;

    @Override
    public TProductInfo findOne(String productId) {
        return productInfoDao.findById(productId).get();
    }

    @Override
    public List<TProductInfo> findUp() {
        return productInfoDao.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<TProductInfo> findAll(Pageable pageable) {
        return productInfoDao.findAll(pageable);
    }

    @Override
    public TProductInfo save(TProductInfo productInfo) {
        return productInfoDao.save(productInfo);
    }
}
