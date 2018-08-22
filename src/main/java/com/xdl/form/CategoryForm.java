package com.xdl.form;

import lombok.Data;

/**
 * 类目表单
 *
 * @author xdl
 * @date 2018-08-21
 */
@Data
public class CategoryForm {

    private Integer categoryId;

    /**
     * 类目名字.
     */
    private String categoryName;

    /**
     * 类目编号.
     */
    private Integer categoryType;
}
