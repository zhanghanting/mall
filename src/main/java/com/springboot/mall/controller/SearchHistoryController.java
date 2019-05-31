package com.springboot.mall.controller;


import com.springboot.mall.service.SearchHistoryService;
import com.springboot.mall.service.impl.SearchHistoryServiceImpl;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@RequestMapping("/admin")
@Controller
public class SearchHistoryController {

    @Autowired
    SearchHistoryService searchHistoryService = new SearchHistoryServiceImpl();

    @ResponseBody
    @RequestMapping("/history/list")
    public JsonUtil searchHistoryList(PageUtils pageUtils){

        JsonUtil searchHistoryList = searchHistoryService.queryAllSearchHistory(pageUtils);
        return searchHistoryList;
    }
}
