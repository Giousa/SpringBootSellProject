package com.zmm.sell.service;

import com.zmm.sell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2018/9/29
 * Email:65489469@qq.com
 */
public interface ProductServic {

    ProductInfo findById(String id);

    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存

    //减库存
}
