package com.springboot.mall.controller.mallsmanagement;

import com.springboot.mall.domain.Order;
import com.springboot.mall.service.mallsmanagement.OrderService;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/list")
    public JsonUtil list(PageUtils pageUtils, Integer[] orderStatusArray, Order order){
        return orderService.viewAllOrder(pageUtils,orderStatusArray,order);
    }

    @RequestMapping("/detail")
    public JsonUtil detail(Integer id){
        return orderService.viewOrderById(id);
    }
}
