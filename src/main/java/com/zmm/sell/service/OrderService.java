package com.zmm.sell.service;

import com.zmm.sell.dataobject.OrderMaster;
import com.zmm.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2018/10/5
 * Email:65489469@qq.com
 */
public interface OrderService {

    OrderDTO create(OrderDTO orderDTO);

    OrderDTO findById(String orderId);

    Page<OrderDTO> findList(String buyerOrderid, Pageable pageable);

    OrderDTO cancel(OrderDTO orderDTO);

    OrderDTO finish(OrderDTO orderDTO);

    OrderDTO paid(OrderDTO orderDTO);

}
