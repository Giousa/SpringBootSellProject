package com.zmm.sell.service;

import com.zmm.sell.dto.OrderDTO;

/**
 * Description:买家
 * Author:zhangmengmeng
 * Date:2018/10/18
 * Email:65489469@qq.com
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);
    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);
}
