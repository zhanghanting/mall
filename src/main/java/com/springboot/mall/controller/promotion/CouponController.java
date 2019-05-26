package com.springboot.mall.controller.promotion;

import com.springboot.mall.domain.Coupon;
import com.springboot.mall.domain.CouponUser;
import com.springboot.mall.domain.GrouponRules;
import com.springboot.mall.service.promotion.CouponService;
import com.springboot.mall.service.promotion.CouponUserService;
import com.springboot.mall.utils.CouponConstant;
import com.springboot.mall.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/25 15:54
 */

@Controller
@RequestMapping("/coupon")
public class CouponController  {

    @Autowired
    CouponService couponService;

    @Autowired
    CouponUserService couponUserService;

    //获取列表 (name、type、type为空时返回全部列表)
    @RequestMapping("/list")
    @ResponseBody
    public Object listItems(String name, Short type, Short status, Integer page, Integer limit, String sort, String order) {
        List<Coupon> couponList = couponService.querySelective(name, type, status, page, limit, sort, order);
        return ResponseUtil.okList(couponList);
    }

    //查询用户
    @RequestMapping("/listuser")
    @ResponseBody
    public Object listUser(Integer userId, Integer couponId, Short status, Integer page, Integer limit, String sort, String order) {
        List<CouponUser> couponList = couponUserService.queryList(userId, couponId, status, page, limit, sort, order);
        return ResponseUtil.okList(couponList);
    }

    //判断coupon是否合法(优惠券名称为必填项)
    private Object validate(Coupon coupon) {
        String name = coupon.getName();
        if(StringUtils.isEmpty(name)){
            return ResponseUtil.badArgument();
        }
        return null;
    }


    //添加
    @RequestMapping("/create")
    @ResponseBody
    public Object create(@RequestBody Coupon coupon) {
        Object error = validate(coupon);
        if (error != null) {
            return error;
        }

        // 如果是兑换码类型，则这里需要生存一个兑换码
        if (coupon.getType().equals(CouponConstant.TYPE_CODE)){
            String code = couponService.generateCode();
            coupon.setCode(code);
        }

        couponService.add(coupon);
        return ResponseUtil.ok(coupon);
    }


    //详情
    @RequestMapping("/read")
    @ResponseBody
    public Object read(@NotNull Integer id) {
        Coupon coupon = couponService.findById(id);
        return ResponseUtil.ok(coupon);
    }


    //编辑
    @RequestMapping("/update")
    @ResponseBody
    public Object update(@RequestBody Coupon coupon) {
        Object error = validate(coupon);
        if (error != null) {
            return error;
        }
        if (couponService.updateById(coupon) == 0) {
            return ResponseUtil.updatedDataFailed();
        }
        return ResponseUtil.ok(coupon);
    }



    //删除
    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(@RequestBody Coupon coupon) {
        couponService.deleteById(coupon.getId());
        return ResponseUtil.ok();
    }


}
