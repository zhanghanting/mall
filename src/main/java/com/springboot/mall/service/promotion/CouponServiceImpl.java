package com.springboot.mall.service.promotion;

import com.github.pagehelper.PageHelper;
import com.springboot.mall.domain.Coupon;
import com.springboot.mall.domain.CouponExample;
import com.springboot.mall.mapper.CouponMapper;
import com.springboot.mall.utils.CouponConstant;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/25 17:30
 */

@Service
public class CouponServiceImpl implements CouponService {

    @Resource
    private CouponMapper couponMapper;

    @Override
    public List<Coupon> querySelective(String name, Short type, Short status, Integer page, Integer limit, String sort, String order) {
        CouponExample couponExample = new CouponExample();
        CouponExample.Criteria criteria = couponExample.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        if (type != null) {
            criteria.andTypeEqualTo(type);
        }
        if (status != null) {
            criteria.andStatusEqualTo(status);
        }
        criteria.andDeletedEqualTo(false);


        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            couponExample.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);

        List<Coupon> coupons = couponMapper.selectByExample(couponExample);
        return coupons;

    }

    /**
     * 生成优惠码
     *
     * @return 可使用优惠码
     */
    @Override
    public String generateCode() {
        String code = getRandomNum(8);
        while(findByCode(code) != null){
            code = getRandomNum(8);
        }
        return code;
    }

    @Override
    public void add(Coupon coupon) {
        coupon.setAddTime(new Date());
        coupon.setUpdateTime(new Date());
        couponMapper.insertSelective(coupon);
    }

    @Override
    public Coupon findById(Integer id) {
        return couponMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateById(Coupon coupon) {
        coupon.setUpdateTime(new Date());
        return couponMapper.updateByPrimaryKeySelective(coupon);
    }

    @Override
    public void deleteById(Integer id) {
        couponMapper.deleteByPrimaryKey(id);
    }

    private Coupon findByCode(String code) {
        CouponExample example = new CouponExample();
        example.or().andCodeEqualTo(code).andTypeEqualTo(CouponConstant.TYPE_CODE).andStatusEqualTo(CouponConstant.STATUS_NORMAL).andDeletedEqualTo(false);
        List<Coupon> couponList =  couponMapper.selectByExample(example);
        if(couponList.size() > 1){
            throw new RuntimeException("");
        }
        else if(couponList.size() == 0){
            return null;
        }
        else {
            return couponList.get(0);
        }
    }

    private String getRandomNum(Integer num) {
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        base += "0123456789";

        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
