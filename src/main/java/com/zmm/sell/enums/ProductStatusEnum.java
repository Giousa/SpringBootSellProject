package com.zmm.sell.enums;

import lombok.Getter;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2018/9/29
 * Email:65489469@qq.com
 */

@Getter
public enum  ProductStatusEnum {

    UP(0,"在架"),
    DOWN(1,"下架");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
