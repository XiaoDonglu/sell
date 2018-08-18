package com.xdl.service;

import com.xdl.model.TProductCategory;

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
    TProductCategory findOne(Integer categoryId);

    /**
     * 查找所有类目
     *
     * @return
     */
    List<TProductCategory> findAll();

    /**
     * 通过类目编号list查询类目list
     *
     * @param categoryTypeList
     * @return
     */
    List<TProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /**
     * 添加和修改类目
     *
     * @param productCategory
     * @return
     */
    TProductCategory save(TProductCategory productCategory);

}
