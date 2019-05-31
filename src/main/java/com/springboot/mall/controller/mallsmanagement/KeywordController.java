package com.springboot.mall.controller.mallsmanagement;

import com.springboot.mall.domain.Keyword;
import com.springboot.mall.service.mallsmanagement.KeywordService;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/keyword")
public class KeywordController {

    @Autowired
    KeywordService keywordService;

    @RequestMapping("/list")
    public JsonUtil list(PageUtils pageUtils, Keyword keyword){
        return keywordService.viewAllKeywords(pageUtils,keyword);
    }
    @RequestMapping("/create")
    public JsonUtil create(@RequestBody Keyword keyword){
        return keywordService.insertKeyword(keyword);
    }
    @RequestMapping("/delete")
    public JsonUtil delete(@RequestBody Keyword keyword){
        return keywordService.deleteKeywordById(keyword);
    }
    @RequestMapping("/update")
    public JsonUtil update(@RequestBody Keyword keyword){
        return keywordService.updateKeywordById(keyword);
    }
}
