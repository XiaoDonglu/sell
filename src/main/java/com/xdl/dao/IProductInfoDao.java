package com.xdl.dao;

import com.xdl.model.TProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品
 *
 * @author xdl
 * @date 2018-08-18
 */
public interface IProductInfoDao extends JpaRepository<TProductInfo, String> {
    /**
     * 通过商品状态查询商品list
     *
     * @param productStatus
     * @return
     */
    List<TProductInfo> findByProductStatus(Integer productStatus);
}
