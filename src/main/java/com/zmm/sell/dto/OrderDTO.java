package com.zmm.sell.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zmm.sell.dataobject.OrderDetail;
import com.zmm.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2018/10/5
 * Email:65489469@qq.com
 */
@Data
public class OrderDTO {

    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal buyerAmount;

    private Integer orderStatus;

    private Integer payStatus;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    private List<OrderDetail> orderDetailList;
}
