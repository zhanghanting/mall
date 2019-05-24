package com.springboot.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.mall.domain.Category;
import com.springboot.mall.mapper.CategoryMapper;
import com.springboot.mall.service.CategoryService;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.MallPageHelper;
import com.springboot.mall.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public JsonUtil viewAllCategory(PageUtils pageUtils) {
        /*PageHelper.startPage(pageUtils.getPage(),pageUtils.getLimit());
        List<Category> categories = categoryMapper.viewAllCategory();
        PageInfo pageInfo = new PageInfo(categories);
        MallPageHelper mallPageHelper = new MallPageHelper();
        mallPageHelper.setItems(categories);
        mallPageHelper.setTotal(pageInfo.getTotal());*/
        List<Category> categories = categoryMapper.viewAllCategory();
        return new JsonUtil(categories,0,"OK");
    }
}
