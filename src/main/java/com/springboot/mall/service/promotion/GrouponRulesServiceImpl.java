package com.springboot.mall.service.promotion;

import com.github.pagehelper.PageHelper;
import com.springboot.mall.domain.GrouponRules;
import com.springboot.mall.domain.GrouponRulesExample;
import com.springboot.mall.mapper.GrouponRulesMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/26 11:14
 */

@Service
public class GrouponRulesServiceImpl implements GrouponRulesService {

    @Resource
    GrouponRulesMapper mapper;

    @Override
    public List<GrouponRules> querySelective(String goodsId, Integer page, Integer size, String sort, String order) {
        GrouponRulesExample example = new GrouponRulesExample();
        example.setOrderByClause(sort + " " + order);

        GrouponRulesExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(goodsId)) {
            criteria.andGoodsIdEqualTo(Integer.parseInt(goodsId));
        }
        criteria.andDeletedEqualTo(false);

        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }

    @Override
    public int updateById(GrouponRules grouponRules) {
        grouponRules.setUpdateTime(new Date());
        return mapper.updateByPrimaryKeySelective(grouponRules);
    }

    @Override
    public int createRules(GrouponRules grouponRules) {
        grouponRules.setAddTime(new Date());
        grouponRules.setUpdateTime(new Date());
        return mapper.insertSelective(grouponRules);
    }

    @Override
    public void delete(Integer id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public GrouponRules queryById(Integer rulesId) {
        GrouponRulesExample example = new GrouponRulesExample();
        example.or().andIdEqualTo(rulesId).andDeletedEqualTo(false);
        return mapper.selectOneByExample(example);
    }
}
