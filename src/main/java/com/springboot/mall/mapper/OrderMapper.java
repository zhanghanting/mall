package com.springboot.mall.mapper;

import com.springboot.mall.domain.Order;
import com.springboot.mall.domain.OrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface OrderMapper {


    List<Order> viewAllOrder(@Param("sort") String sort, @Param("order") String order , @Param("orderStatusArray") Integer[] orderStatusArray, @Param("orderBean") Order orderBean);

    Order viewOrderById(@Param("id") Integer id);
}