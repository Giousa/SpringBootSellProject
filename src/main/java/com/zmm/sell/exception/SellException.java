package com.zmm.sell.exception;

import com.zmm.sell.enums.ResultEnum;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2018/10/5
 * Email:65489469@qq.com
 */
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }


    public SellException(Integer code,String message){
        super(message);
        this.code = code;
    }

}
