package com.springboot.mall.service.mallsmanagement.impl;

import com.springboot.mall.domain.Category;
import com.springboot.mall.domain.vo.CategoryVo;
import com.springboot.mall.domain.vo.LevelOne;
import com.springboot.mall.mapper.CategoryMapper;
import com.springboot.mall.service.mallsmanagement.CategoryService;
import com.springboot.mall.utils.JsonUtil;
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
        List<CategoryVo> categories = categoryMapper.viewAllCategories();
        return new JsonUtil(categories,0,"成功");
    }

    @Override
    public JsonUtil insertCategory(Category category) {
        categoryMapper.insertCategory(category);
        return new JsonUtil(category,0,"OK");
    }

    @Override
    public JsonUtil viewAllLevelOne() {
        List<LevelOne> levelOnes = categoryMapper.viewAllLevelOne();
        return new JsonUtil(levelOnes,0,"OK");
    }

    @Override
    public JsonUtil updateCategory(Category category) {
        categoryMapper.updateCategory(category);
        return new JsonUtil(category,0,"成功");
    }

    @Override
    public JsonUtil deleteCategoryById(Category category) {
        categoryMapper.deleteCategoryById(category);
        return new JsonUtil(null,0,"成功");
    }
}
