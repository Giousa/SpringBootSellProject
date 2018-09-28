package com.zmm.sell.repository;

import com.zmm.sell.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2018/9/28
 * Email:65489469@qq.com
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        ProductCategory productCategory = repository.findById(1).get();
        System.out.println("productCategory = "+productCategory);
    }


    @Test
    public void addTest(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("测试02");
        productCategory.setCategoryType(2);

        repository.save(productCategory);
    }


    @Test
    @Transactional
    public void updateTest(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(2);
        productCategory.setCategoryName("更新02");
        productCategory.setCategoryType(22);

        repository.save(productCategory);
    }


    @Test
    @Transactional
    public void updateTest2(){
        ProductCategory productCategory = repository.findById(1).get();
        productCategory.setCategoryType(121);

        repository.save(productCategory);
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<ProductCategory> productCategoryList = repository.findByCategoryTypeIn(Arrays.asList(11, 22, 33));

        System.out.println("productCategoryList = "+productCategoryList);
    }
}