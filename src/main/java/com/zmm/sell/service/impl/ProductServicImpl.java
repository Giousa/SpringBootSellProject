package com.zmm.sell.service.impl;

import com.zmm.sell.dataobject.ProductInfo;
import com.zmm.sell.enums.ProductStatusEnum;
import com.zmm.sell.repository.ProductInfoRepository;
import com.zmm.sell.service.ProductServic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2018/9/29
 * Email:65489469@qq.com
 */
@Service
public class ProductServicImpl implements ProductServic {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findById(String id) {
        return repository.findById(id).get();
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }
}
