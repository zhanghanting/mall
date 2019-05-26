package com.springboot.mall.service.promotion;

import com.github.pagehelper.PageHelper;
import com.springboot.mall.domain.CouponUser;
import com.springboot.mall.domain.CouponUserExample;
import com.springboot.mall.mapper.CouponUserMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/26 10:39
 */
@Service
public class couponUserServiceImpl implements CouponUserService {

    @Resource
    private CouponUserMapper couponUserMapper;

    @Override
    public List<CouponUser> queryList(Integer userId, Integer couponId, Short status, Integer page, Integer size, String sort, String order) {
        CouponUserExample example = new CouponUserExample();
        CouponUserExample.Criteria criteria = example.createCriteria();
        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        }
        if(couponId != null){
            criteria.andCouponIdEqualTo(couponId);
        }
        if (status != null) {
            criteria.andStatusEqualTo(status);
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        if (!StringUtils.isEmpty(page) && !StringUtils.isEmpty(size)) {
            PageHelper.startPage(page, size);
        }

        return couponUserMapper.selectByExample(example);
    }
}
