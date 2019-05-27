package com.springboot.mall.service.promotion;

import com.springboot.mall.domain.Coupon;

import java.util.List;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/25 17:30
 */

public interface CouponService {
    List<Coupon> querySelective(String name, Short type, Short status, Integer page, Integer limit, String sort, String order);

    String generateCode();

    void add(Coupon coupon);

    Coupon findById(Integer id);

    int updateById(Coupon coupon);

    void deleteById(Integer id);
}
