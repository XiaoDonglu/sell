package com.xdl.dao;

import com.xdl.model.TProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 类目
 *
 * @author xdl
 * @date 2018-08-18
 */
public interface IProductCategoryDao extends JpaRepository<TProductCategory, Integer> {

    /**
     * 通过类目编号list查询类目list
     *
     * @param categoryTypeList
     * @return
     */
    List<TProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
