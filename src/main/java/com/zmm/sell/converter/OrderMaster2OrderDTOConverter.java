package com.zmm.sell.converter;

import com.zmm.sell.dataobject.OrderMaster;
import com.zmm.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2018/10/10
 * Email:65489469@qq.com
 */
public class OrderMaster2OrderDTOConverter {


    public static OrderDTO convert(OrderMaster orderMaster){

        OrderDTO orderDTO = new OrderDTO();

        BeanUtils.copyProperties(orderMaster,orderDTO);

        return orderDTO;

    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){

        List<OrderDTO> orderDTOList = orderMasterList.stream()
                .map(e -> convert(e))
                .collect(Collectors.toList());

        return orderDTOList;

    }
}
