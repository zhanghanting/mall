package com.springboot.mall.service.mallsmanagement.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.mall.domain.Order;
import com.springboot.mall.domain.OrderGoods;
import com.springboot.mall.domain.User;
import com.springboot.mall.mapper.OrderGoodsMapper;
import com.springboot.mall.mapper.OrderMapper;
import com.springboot.mall.mapper.UserMapper;
import com.springboot.mall.service.mallsmanagement.OrderService;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.MallPageHelper;
import com.springboot.mall.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    OrderGoodsMapper orderGoodsMapper;

    @Override
    public JsonUtil viewAllOrder(PageUtils pageUtils,Integer[] orderStatusArray,Order order) {
        PageHelper.startPage(pageUtils.getPage(),pageUtils.getLimit());
        List<Order> orders = orderMapper.viewAllOrder(pageUtils.getSort(),pageUtils.getOrder(),orderStatusArray,order);
        PageInfo pageInfo = new PageInfo(orders);
        MallPageHelper mallPageHelper = new MallPageHelper();
        mallPageHelper.setTotal(pageInfo.getTotal());
        mallPageHelper.setItems(orders);
        return new JsonUtil(mallPageHelper,0,"成功");
    }

    @Override
    public JsonUtil viewOrderById(Integer id) {
        Order order = orderMapper.viewOrderById(id);
        List<OrderGoods> orderGoods = orderGoodsMapper.viewOrderByOrderId(order.getId());
        User user = userMapper.viewUserById(order.getUserId());
        Map<String,Object> map = new TreeMap<>();
        map.put("order",order);
        map.put("orderGoods",orderGoods);
        map.put("user",user);
        return new JsonUtil(map,0,"成功");
    }
}
