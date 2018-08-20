package com.xdl.dao;

import com.xdl.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 类目
 *
 * @author xdl
 * @date 2018-08-18
 */
public interface IProductCategoryDao extends JpaRepository<ProductCategory, Integer> {

    /**
     * 通过类目编号list查询类目list
     *
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
