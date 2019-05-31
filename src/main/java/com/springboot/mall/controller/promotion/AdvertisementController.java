package com.springboot.mall.controller.promotion;

import com.springboot.mall.domain.Ad;
import com.springboot.mall.service.promotion.AdService;
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
 * @Date: 2019/5/23 19:59
 */

@Controller
@RequestMapping("/admin/ad")
public class AdvertisementController {

    @Autowired
    AdService adService;


    //name和content为空时,返回全部列表;name或content不为空时,按搜索条件返回相应列表
    @RequestMapping("list")
    @ResponseBody
    public Object getItemList(String name, String content, Integer page, Integer limit, String sort, String order){
        List<Ad> adList = adService.querySelective(name, content, page, limit, sort, order);
        return ResponseUtil.okList(adList);
    }


    //判断广告是否非法(广告标题和广告内容不为空)
    private Object validate(Ad ad){
        String name = ad.getName();
        if (StringUtils.isEmpty(name)) {
            return ResponseUtil.badArgument();
        }

        String content = ad.getContent();
        if (StringUtils.isEmpty(content)) {
            return ResponseUtil.badArgument();
        }

        return null;
    }

    //添加
    @RequestMapping("create")
    @ResponseBody
    public Object create(@RequestBody Ad ad){
        Object error = validate(ad);
        if (error != null){
            return error;
        }
        adService.add(ad);
        return ResponseUtil.ok(ad);
    }

    @RequestMapping("/read")
    public Object read(@NotNull Integer id) {
        Ad ad = adService.findById(id);
        return ResponseUtil.ok(ad);
    }

    //编辑
    @RequestMapping("update")
    @ResponseBody
    public Object update(@RequestBody Ad ad){
        Object error = validate(ad);
        if (error != null) {
            return error;
        }
        if (adService.updateById(ad) == 0) {
            return ResponseUtil.updatedDataFailed();
        }

        return ResponseUtil.ok(ad);
    }


    //删除
    @RequestMapping("delete")
    @ResponseBody
    public Object delete(@RequestBody Ad ad) {
        Integer id = ad.getId();
        if (id == null) {
            return ResponseUtil.badArgument();
        }
        adService.deleteById(id);
        return ResponseUtil.ok();
    }
}
