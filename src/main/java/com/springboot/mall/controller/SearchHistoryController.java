package com.springboot.mall.controller;


import com.springboot.mall.service.SearchHistoryService;
import com.springboot.mall.service.impl.SearchHistoryServiceImpl;
import com.springboot.mall.utils.JsonBean;
import com.springboot.mall.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SearchHistoryController {

    @Autowired
    SearchHistoryService searchHistoryService = new SearchHistoryServiceImpl();

    @ResponseBody
    @RequestMapping("/history/list")
    public JsonBean searchHistoryList(PageUtils pageUtils){

        JsonBean searchHistoryList = searchHistoryService.queryAllSearchHistory(pageUtils);
        return searchHistoryList;
    }
}
