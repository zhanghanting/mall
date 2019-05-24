package com.springboot.mall.service.promotion;

import com.springboot.mall.utils.MyPageHelper;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/23 21:03
 */

public interface PromotionService {

    MyPageHelper getList(Integer page, Integer rows, String sort, String order);
}
