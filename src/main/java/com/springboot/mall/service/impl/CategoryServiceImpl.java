package com.springboot.mall.service.impl;


import com.springboot.mall.mapper.CategoryMapper;
import com.springboot.mall.service.mallsmanagement.CategoryService;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public JsonUtil viewAllCategory(PageUtils pageUtils) {
         /*List<Category> categoryMapper.viewAllCategory()*/
        return null;
    }
}
