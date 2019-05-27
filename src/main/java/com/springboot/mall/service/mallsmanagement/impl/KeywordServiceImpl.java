package com.springboot.mall.service.mallsmanagement.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.mall.domain.Keyword;
import com.springboot.mall.mapper.KeywordMapper;
import com.springboot.mall.service.mallsmanagement.KeywordService;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.MallPageHelper;
import com.springboot.mall.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordServiceImpl implements KeywordService {
    @Autowired
    KeywordMapper keywordMapper;

    @Override
    public JsonUtil viewAllKeywords(PageUtils pageUtils, Keyword keyword) {
        PageHelper.startPage(pageUtils.getPage(),pageUtils.getLimit());
        List<Keyword> keywords = keywordMapper.viewAllKeywords(pageUtils.getSort(),pageUtils.getOrder(),keyword);
        PageInfo pageInfo = new PageInfo(keywords);
        MallPageHelper mallPageHelper = new MallPageHelper();
        mallPageHelper.setTotal(pageInfo.getTotal());
        mallPageHelper.setItems(keywords);
        return new JsonUtil(mallPageHelper,0,"成功");
    }

    @Override
    public JsonUtil insertKeyword(Keyword keyword) {
        keywordMapper.insertKeyword(keyword);
        return new JsonUtil(keyword,0,"成功");
    }

    @Override
    public JsonUtil deleteKeywordById(Keyword keyword) {
        keywordMapper.deleteKeywordById(keyword);
        return new JsonUtil(keyword,0,"成功");
    }

    @Override
    public JsonUtil updateKeywordById(Keyword keyword) {
        keywordMapper.updateKeywordById(keyword);
        return new JsonUtil(keyword,0,"成功");
    }
}
