package com.zmm.sell.repository;

import com.zmm.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2018/9/28
 * Email:65489469@qq.com
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

//    List<ProductCategory> findByCategoryTypeIn(List<Integer> list);

    List<ProductCategory> findByCategoryTypeIn(List<Integer> list);

}
