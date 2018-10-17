package com.zmm.sell.service.impl;

import com.zmm.sell.dataobject.OrderDetail;
import com.zmm.sell.dto.OrderDTO;
import com.zmm.sell.enums.OrderStatusEnum;
import com.zmm.sell.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.criterion.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2018/10/9
 * Email:65489469@qq.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderserviceImplTest {

    @Autowired
    private OrderserviceImpl orderservice;

    private final String BUYER_ORDERID = "12121212";

    @Test
    public void create() {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("皇上陛下");
        orderDTO.setBuyerAddress("天庭");
        orderDTO.setBuyerPhone("90909090");
        orderDTO.setBuyerOpenid(BUYER_ORDERID);

        List<OrderDetail> orderDetailsList = new ArrayList<>();

        OrderDetail o1 = new OrderDetail();
        o1.setProductId("5f49fc3a91284b28ba1aca819523e4d4");
        o1.setProductQuantity(1);
        orderDetailsList.add(o1);

        OrderDetail o2 = new OrderDetail();
        o2.setProductId("b354161a919745afacf1e531fb8374c1");
        o2.setProductQuantity(2);
        orderDetailsList.add(o2);


        orderDTO.setOrderDetailList(orderDetailsList);

        OrderDTO result = orderservice.create(orderDTO);

        log.info("【创建订单】result={}",result);

    }

    @Test
    public void findById() {

        OrderDTO orderDTO = orderservice.findById("1539183163026453558");
        log.info("【查询订单】orderDTO = {}",orderDTO);
    }

    @Test
    public void findList() {

        PageRequest pageRequest = new PageRequest(0,10);

        Page<OrderDTO> orderDTOPage = orderservice.findList(BUYER_ORDERID, pageRequest);

        log.info("【查询全部订单】orderDTOPage = {}",orderDTOPage.getContent());

    }

    @Test
    public void cancel() {

        OrderDTO orderDTO = orderservice.findById("1539183163026453558");

        OrderDTO cancel = orderservice.cancel(orderDTO);

        if(cancel.getOrderStatus().equals(OrderStatusEnum.FINISHED.getCode())){
            log.info("【取消订单】成功");
        }else {
            log.info("【取消订单】失败");
        }


    }

    @Test
    public void finish() {

        OrderDTO orderDTO = orderservice.findById("1539183163026453558");

        OrderDTO finish = orderservice.finish(orderDTO);

        System.out.println("finish.getOrderStatus() = "+finish.getOrderStatus());

    }

    @Test
    public void paid() {

        OrderDTO orderDTO = orderservice.findById("1539183163026453558");

        OrderDTO paid = orderservice.paid(orderDTO);

        System.out.println("paid.getPayStatus() = "+paid.getPayStatus());
    }
}