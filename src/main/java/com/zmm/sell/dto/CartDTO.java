package com.zmm.sell.dto;

import lombok.Data;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2018/10/9
 * Email:65489469@qq.com
 */
@Data
public class CartDTO {

    private String productId;

    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
