package com.springboot.mall.service.promotion;

import com.github.pagehelper.PageHelper;
import com.springboot.mall.domain.Groupon;
import com.springboot.mall.domain.GrouponExample;
import com.springboot.mall.mapper.GrouponMapper;
import com.springboot.mall.utils.ResponseUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/26 11:07
 */

@Service
public class GrouponServiceImpl implements GrouponService {

    @Resource
    private GrouponMapper mapper;
    /**
     * 查询所有发起的团购记录
     *
     * @param grouponId
     * @param page
     * @param limit
     * @param sort
     * @param order
     * @return
     */
    @Override
    public List<Groupon> querySelective(String grouponId, Integer page, Integer limit, String sort, String order) {
        GrouponExample example = new GrouponExample();
        GrouponExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(grouponId)) {
            criteria.andRulesIdEqualTo(Integer.parseInt(grouponId));
        }
        criteria.andDeletedEqualTo(false);
        criteria.andPayedEqualTo(true);
        criteria.andGrouponIdEqualTo(0);

        PageHelper.startPage(page, limit);
        return mapper.selectByExample(example);
    }

    /**
     * 获取某个团购活动参与的记录
     *
     * @param id
     * @return
     */
    @Override
    public List<Groupon> queryJoinRecord(Integer id) {
        GrouponExample example = new GrouponExample();
        example.or().andGrouponIdEqualTo(id).andDeletedEqualTo(false).andPayedEqualTo(true);
        //example.orderBy("add_time desc");
        return mapper.selectByExample(example);
    }
}
