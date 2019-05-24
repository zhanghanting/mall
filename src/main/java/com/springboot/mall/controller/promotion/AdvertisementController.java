package com.springboot.mall.controller.promotion;

import com.springboot.mall.service.promotion.PromotionService;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/23 19:59
 */

@Controller
@RequestMapping("/ad")
public class AdvertisementController {

    @Autowired
    PromotionService promotionService;



    //name为空时,返回全部列表;name不为空时,按搜索条件返回相应列表
    @RequestMapping("list")
    @ResponseBody
    public JsonUtil getItemList(Integer page, Integer rows, String sort, String order){

        MyPageHelper result = promotionService.getList(page,rows,sort,order);

        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setErrno(0);
        jsonUtil.setErrmsg("成功");
        jsonUtil.setData(result);

        return jsonUtil;
    }


}
