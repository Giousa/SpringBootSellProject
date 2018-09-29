package com.zmm.sell.vo;

import lombok.Data;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2018/9/29
 * Email:65489469@qq.com
 */
@Data
public class ResultVO<T> {


    private Integer code;

    private String msg;

    private T data;
}
