package com.xdl.repository;

import com.xdl.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品
 *
 * @author xdl
 * @date 2018-08-18
 */
public interface ProductInfoDao extends JpaRepository<ProductInfo, String> {
    /**
     * 通过商品状态查询商品list
     *
     * @param productStatus
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
