package com.zmm.sell.service;

import com.zmm.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2018/9/28
 * Email:65489469@qq.com
 */
public interface CategoryService {

    ProductCategory findOne(Integer id);

    List<ProductCategory> findAll();

    List<ProductCategory> findByType(List<Integer> list);

    ProductCategory save(ProductCategory productCategory);
}
