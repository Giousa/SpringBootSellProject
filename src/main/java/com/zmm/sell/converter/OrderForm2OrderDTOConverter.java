package com.zmm.sell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zmm.sell.dataobject.OrderDetail;
import com.zmm.sell.dto.OrderDTO;
import com.zmm.sell.enums.ResultEnum;
import com.zmm.sell.exception.SellException;
import com.zmm.sell.form.OrderForm;

import java.util.List;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2018/10/17
 * Email:65489469@qq.com
 */
public class OrderForm2OrderDTOConverter {


    public static OrderDTO convert(OrderForm orderForm){

        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList;

        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),new TypeToken<List<OrderDetail>>(){}.getType());

        }catch (Exception e){
            e.printStackTrace();
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
