package com.xdl.service;

import com.xdl.model.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商品
 *
 * @author xdl
 * @date 2018-08-18
 */
public interface IProductService {

    /**
     * 根据商品id查找商品
     *
     * @param productId
     * @return
     */
    ProductInfo findOne(String productId);

    /**
     * 查询所有上架的商品
     *
     * @return
     */
    List<ProductInfo> findUp();

    /**
     * 查询所有的商品，带分页
     *
     * @param pageable
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 保存商品信息
     *
     * @param productInfo
     * @return
     */
    ProductInfo save(ProductInfo productInfo);

    //TODO 加库存

    //TODO 减库存

}
