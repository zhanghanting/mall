package com.springboot.mall.controller.promotion;

import com.springboot.mall.domain.Goods;
import com.springboot.mall.domain.Groupon;
import com.springboot.mall.domain.GrouponRules;
import com.springboot.mall.service.promotion.GoodsService;
import com.springboot.mall.service.promotion.GrouponRulesService;
import com.springboot.mall.service.promotion.GrouponService;
import com.springboot.mall.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.*;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/26 11:06
 */
@Controller
@RequestMapping("/admin/groupon")
public class GrouponController {
    @Autowired
    private GrouponService grouponService;

    @Autowired
    GrouponRulesService rulesService;

    @Autowired
    private GoodsService goodsService;




    //获取团购活动列表 ( goodsId为空时返回全部列表)
    @RequestMapping("/list")
    @ResponseBody
    public Object list(String goodsId, Integer page, Integer limit, String sort, String order) {
        List<GrouponRules> rulesList = rulesService.querySelective(goodsId, page, limit, sort, order);
        return ResponseUtil.okList(rulesList);
    }


    //获取团购规则列表  ( grouponId为空时返回全部列表)
    @RequestMapping("/listRecord")
    @ResponseBody
    public Object listRecord(String grouponId, Integer page, Integer limit, String sort, String order) {
        List<Groupon> grouponList = grouponService.querySelective(grouponId, page, limit, sort, order);

        List<Map<String, Object>> groupons = new ArrayList<>();
        for (Groupon groupon : grouponList) {
            try {
                Map<String, Object> RecordData = new HashMap<>();
                List<Groupon> subGrouponList = grouponService.queryJoinRecord(groupon.getId());
                GrouponRules rules = rulesService.queryById(groupon.getRulesId());
                Goods goods = goodsService.findById(rules.getGoodsId());

                RecordData.put("groupon", groupon);
                RecordData.put("subGroupons", subGrouponList);
                RecordData.put("rules", rules);
                RecordData.put("goods", goods);

                groupons.add(RecordData);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return ResponseUtil.okList(groupons, grouponList);
    }

    //检查是否合法
    private Object validate(GrouponRules grouponRules) {
        Integer goodsId = grouponRules.getGoodsId();
        if (goodsId == null) {
            return ResponseUtil.badArgument();
        }
        BigDecimal discount = grouponRules.getDiscount();
        if (discount == null) {
            return ResponseUtil.badArgument();
        }
        Integer discountMember = grouponRules.getDiscountMember();
        if (discountMember == null) {
            return ResponseUtil.badArgument();
        }
        Date expireTime = grouponRules.getExpireTime();
        if (expireTime == null) {
            return ResponseUtil.badArgument();
        }
        return null;
    }


    //编辑
    @RequestMapping("/update")
    @ResponseBody
    public Object update(@RequestBody GrouponRules grouponRules) {
        Object error = validate(grouponRules);
        if (error != null) {
            return error;
        }

        Integer goodsId = grouponRules.getGoodsId();
        Goods goods = goodsService.findById(goodsId);
        if (goods == null) {
            return ResponseUtil.badArgumentValue();
        }

        grouponRules.setGoodsName(goods.getName());
        grouponRules.setPicUrl(goods.getPicUrl());

        if (rulesService.updateById(grouponRules) == 0) {
            return ResponseUtil.updatedDataFailed();
        }

        return ResponseUtil.ok();
    }


    //添加
    @RequestMapping("/create")
    @ResponseBody
    public Object create(@RequestBody GrouponRules grouponRules) {
        Object error = validate(grouponRules);
        if (error != null) {
            return error;
        }

        Integer goodsId = grouponRules.getGoodsId();
        Goods goods = goodsService.findById(goodsId);
        if (goods == null) {
            return ResponseUtil.badArgumentValue();
        }

        grouponRules.setGoodsName(goods.getName());
        grouponRules.setPicUrl(goods.getPicUrl());

        rulesService.createRules(grouponRules);

        return ResponseUtil.ok(grouponRules);
    }


    //删除
    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(@RequestBody GrouponRules grouponRules) {
        Integer id = grouponRules.getId();
        if (id == null) {
            return ResponseUtil.badArgument();
        }

        rulesService.delete(id);
        return ResponseUtil.ok();
    }
}
