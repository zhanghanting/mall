package com.springboot.mall.service.promotion;

import com.springboot.mall.domain.Goods;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/26 11:23
 */

public interface GoodsService {
    Goods findById(Integer goodsId);
}
