package com.springboot.mall.service.promotion;

import com.springboot.mall.domain.Groupon;

import java.util.List;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/26 11:07
 */

public interface GrouponService {
    List<Groupon> querySelective(String grouponId, Integer page, Integer limit, String sort, String order);

    List<Groupon> queryJoinRecord(Integer id);
}
