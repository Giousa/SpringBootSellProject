package com.zmm.sell.dataobject;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zmm.sell.enums.OrderStatusEnum;
import com.zmm.sell.enums.PayStatusEnum;
import com.zmm.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Id;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2018/9/29
 * Email:65489469@qq.com
 */
@Entity
@Data
@DynamicUpdate
public class OrderDetail {

    @Id
    private String detailId;

    private String orderId;

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productQuantity;

    private String productIcon;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

}
