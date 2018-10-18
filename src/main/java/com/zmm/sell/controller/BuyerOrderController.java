package com.zmm.sell.controller;

import com.zmm.sell.converter.OrderForm2OrderDTOConverter;
import com.zmm.sell.dto.OrderDTO;
import com.zmm.sell.enums.ResultEnum;
import com.zmm.sell.exception.SellException;
import com.zmm.sell.form.OrderForm;
import com.zmm.sell.service.BuyerService;
import com.zmm.sell.service.OrderService;
import com.zmm.sell.utils.ResultVOUtil;
import com.zmm.sell.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2018/10/17
 * Email:65489469@qq.com
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerService buyerService;

    //创建订单
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确,orderForm = {}",orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);

        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDTO orderDTOResult = orderService.create(orderDTO);

        Map<String,String> map = new HashMap<>();
        map.put("orderId",orderDTOResult.getOrderId());

        return ResultVOUtil.success(map);

    }

    //订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page",defaultValue = "0") Integer page,
                                         @RequestParam(value = "size",defaultValue = "10") Integer size){

        if(StringUtils.isEmpty(openid)){
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        Page<OrderDTO> list = orderService.findList(openid, new PageRequest(page, size));

        return ResultVOUtil.success(list.getContent());
    }

    //订单详情

    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("orderId") String orderId,
                                     @RequestParam("openid") String openid){

        OrderDTO orderDTO = buyerService.findOrderOne(openid, orderId);

        return ResultVOUtil.success(orderDTO);

    }

    //取消订单
    @GetMapping("/cancel")
    public ResultVO cancel(@RequestParam("orderId") String orderId,
                           @RequestParam("openid") String openid){

        buyerService.cancelOrder(openid, orderId);

        return ResultVOUtil.success();
    }
}
