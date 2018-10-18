package com.zmm.sell.service.impl;

import com.zmm.sell.dto.OrderDTO;
import com.zmm.sell.enums.ResultEnum;
import com.zmm.sell.exception.SellException;
import com.zmm.sell.service.BuyerService;
import com.zmm.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2018/10/18
 * Email:65489469@qq.com
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {

        OrderDTO orderDTO = orderService.findById(orderId);

        if(orderDTO == null){
            return null;
        }

        if(!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)){
            log.error("【查询订单】订单openid不一致");
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }

        return orderDTO;
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {

        OrderDTO orderOne = findOrderOne(openid, orderId);

        if(orderOne == null){
            log.error("【取消订单】查不到该订单");
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        return orderService.cancel(orderOne);
    }
}
