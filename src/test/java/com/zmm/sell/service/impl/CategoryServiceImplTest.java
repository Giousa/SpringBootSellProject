package com.zmm.sell.service.impl;

import com.zmm.sell.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2018/9/28
 * Email:65489469@qq.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() {

        ProductCategory productCategory = categoryService.findOne(1);
        log.error("findOne : {}",productCategory);
    }

    @Test
    public void findAll() {
        List<ProductCategory> productCategoryList = categoryService.findAll();

        log.error("findAll : {}",productCategoryList);
    }

    @Test
    public void findByType() {

        List<ProductCategory> productCategoryList = categoryService.findByType(Arrays.asList(11, 22, 33));

        log.error("findByType : {}",productCategoryList);
    }

    @Test
    public void save() {

        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("test");
        productCategory.setCategoryType(33);

        categoryService.save(productCategory);
    }
}