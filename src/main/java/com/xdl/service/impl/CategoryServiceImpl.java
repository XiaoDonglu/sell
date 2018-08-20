package com.xdl.service.impl;

import com.xdl.dao.IProductCategoryDao;
import com.xdl.model.ProductCategory;
import com.xdl.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public ProductCategory findOne(Integer categoryId) {
        //springBoot 2.0 后，使用 findById(id).get() 替代 findOne()
        Optional<ProductCategory> optional = productCategoryDao.findById(categoryId);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryDao.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryDao.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryDao.save(productCategory);
    }
}
