package com.springboot.mall.service.promotion;

import com.springboot.mall.domain.CouponUser;

import java.util.List;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/26 10:38
 */

public interface CouponUserService {
    List<CouponUser> queryList(Integer userId, Integer couponId, Short status, Integer page, Integer limit, String sort, String order);
}
