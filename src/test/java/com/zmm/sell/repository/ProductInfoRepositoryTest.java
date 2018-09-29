package com.zmm.sell.repository;

import com.zmm.sell.dataobject.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
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
public class ProductInfoRepositoryTest {


    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void sava(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId(UUID.randomUUID().toString().replace("-",""));
        productInfo.setProductName("test001");
        productInfo.setCategoryType(1);
        BigDecimal bigDecimal = new BigDecimal(123.45f);
        productInfo.setProductPrice(bigDecimal);
        productInfo.setProductStock(111);

        repository.save(productInfo);

    }

    @Test
    public void findByProductStatus() {
    }
}