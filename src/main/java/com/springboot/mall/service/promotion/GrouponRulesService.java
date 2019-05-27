package com.springboot.mall.service.promotion;

import com.springboot.mall.domain.GrouponRules;

import java.util.List;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/26 11:14
 */

public interface GrouponRulesService {
    List<GrouponRules> querySelective(String goodsId, Integer page, Integer limit, String sort, String order);

    int updateById(GrouponRules grouponRules);

    int createRules(GrouponRules grouponRules);

    void delete(Integer id);

    GrouponRules queryById(Integer rulesId);
}
