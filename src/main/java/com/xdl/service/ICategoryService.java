package com.xdl.service;

import com.xdl.model.ProductCategory;

import java.util.List;

/**
 * 类目
 *
 * @author xdl
 * @date 2018-08-18
 */
public interface ICategoryService {

    /**
     * 根据类目id查找类目
     *
     * @param categoryId
     * @return
     */
    ProductCategory findOne(Integer categoryId);

    /**
     * 查找所有类目
     *
     * @return
     */
    List<ProductCategory> findAll();

    /**
     * 通过类目编号list查询类目list
     *
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /**
     * 添加和修改类目
     *
     * @param productCategory
     * @return
     */
    ProductCategory save(ProductCategory productCategory);

}
