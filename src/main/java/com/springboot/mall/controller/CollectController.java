package com.springboot.mall.controller;

import com.springboot.mall.service.CollectService;
import com.springboot.mall.service.impl.CollectServiceImpl;
import com.springboot.mall.utils.JsonBean;
import com.springboot.mall.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CollectController {

    @Autowired
    CollectService collectService = new CollectServiceImpl();

    @ResponseBody
    @RequestMapping("/collect/list")
    public JsonBean collectList(PageUtils pageUtils){

        JsonBean collectList = collectService.queryAllCollect(pageUtils);
        return collectList;
    }

}
