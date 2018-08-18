package com.xdl.controller;

import com.xdl.model.TProductCategory;
import com.xdl.model.TProductInfo;
import com.xdl.service.ICategoryService;
import com.xdl.service.IProductService;
import com.xdl.util.ResultVOUtil;
import com.xdl.vo.ProductInfoVO;
import com.xdl.vo.ProductVO;
import com.xdl.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 *
 * @author xdl
 * @date 2018.08.18
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("list")
    public ResultVO getList() {

        // 获取所有上架的商品
        List<TProductInfo> productInfoList = productService.findUp();

        // 获取所有上架商品的类目id
        List<Integer> categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType())
                .collect(Collectors.toList());

        // 获取所有上架商品的类目
        List<TProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        List<ProductVO> productVOList = new ArrayList<>();
        for (TProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (TProductInfo productInfo : productInfoList) {
                if (productCategory.getCategoryId().equals(productInfo.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);

                    productInfoVOList.add(productInfoVO);
                }
            }

            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
