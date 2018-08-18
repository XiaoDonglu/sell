package com.xdl.service.impl;

import com.xdl.dao.IProductCategoryDao;
import com.xdl.model.TProductCategory;
import com.xdl.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类目
 *
 * @author xdl
 * @date 2018-08-18
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private IProductCategoryDao productCategoryDao;

    @Override
    public TProductCategory findOne(Integer categoryId) {
        /**
         * springBoot 2.0 后，使用 findById(id).get() 替代 findOne()
         */
        return productCategoryDao.findById(categoryId).get();
    }

    @Override
    public List<TProductCategory> findAll() {
        return productCategoryDao.findAll();
    }

    @Override
    public List<TProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryDao.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public TProductCategory save(TProductCategory productCategory) {
        return productCategoryDao.save(productCategory);
    }
}
