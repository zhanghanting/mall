package com.springboot.mall.service.impl;

import com.springboot.mall.domain.Category;
import com.springboot.mall.mapper.CategoryMapper;
import com.springboot.mall.service.CategoryService;
import com.springboot.mall.utils.JsonBean;
import com.springboot.mall.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public JsonBean viewAllCategory(PageUtils pageUtils) {
         /*List<Category> categoryMapper.viewAllCategory()*/
        return null;
    }
}
