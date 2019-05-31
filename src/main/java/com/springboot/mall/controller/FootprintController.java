package com.springboot.mall.controller;

import com.springboot.mall.service.FootprintService;
import com.springboot.mall.service.impl.FootprintServiceImpl;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@RequestMapping("/admin")
@Controller
public class FootprintController {

    @Autowired
    FootprintService footprintService = new FootprintServiceImpl();

    @ResponseBody
    @RequestMapping("/footprint/list")
    public JsonUtil footprintList(PageUtils pageUtils){

        JsonUtil footprintList = footprintService.queryAllFootprint(pageUtils);
        return footprintList;
    }

}
