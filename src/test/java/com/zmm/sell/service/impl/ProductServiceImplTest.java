package com.zmm.sell.service.impl;

import com.zmm.sell.dataobject.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2018/9/29
 * Email:65489469@qq.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductServiceImplTest {

    @Autowired
    private ProductServicImpl productServic;

    @Test
    public void findById() {

        ProductInfo productInfo = productServic.findById("5f49fc3a91284b28ba1aca819523e4d4");

        log.error("findById = {}",productInfo);

    }

    @Test
    public void findUpAll() {

        List<ProductInfo> productInfoList = productServic.findUpAll();

        log.error("findUpAll = {}",productInfoList);
    }

    @Test
    public void findAll() {

        PageRequest pageRequest = new PageRequest(0,10);

        Page<ProductInfo> productInfos = productServic.findAll(pageRequest);

        log.error("findAll = {}",productInfos);
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId(UUID.randomUUID().toString().replace("-",""));
        productInfo.setProductName("test002");
        productInfo.setCategoryType(2);
        BigDecimal bigDecimal = new BigDecimal(123.45);
        productInfo.setProductPrice(bigDecimal);
        productInfo.setProductStock(211);
        productInfo.setProductIcon("http://xxxxxx.jpg");
        productInfo.setProductStatus(1221);
        productInfo.setProductDescription("这个是测试描述");

        ProductInfo save = productServic.save(productInfo);

        log.error("save = {}",save);

    }
}