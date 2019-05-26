package com.springboot.mall.service.mallsmanagement;

import com.springboot.mall.domain.Order;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.PageUtils;

import java.util.ArrayList;
import java.util.List;

public interface OrderService {

    JsonUtil viewAllOrder(PageUtils pageUtils, Integer[] orderStatusArray, Order order);

    JsonUtil viewOrderById(Integer id);
}
