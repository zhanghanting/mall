package com.springboot.mall.service.promotion;

import com.springboot.mall.domain.Ad;

import java.util.List;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/24 17:08
 */

public interface AdService  {
    List<Ad> querySelective(String name, String content, Integer page, Integer limit, String sort, String order);

    void deleteById(Integer id);

    int updateById(Ad ad);

    void add(Ad ad);
}
