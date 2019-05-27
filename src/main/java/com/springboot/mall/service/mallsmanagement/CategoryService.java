package com.springboot.mall.service.mallsmanagement;

import com.springboot.mall.domain.Category;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.PageUtils;

public interface CategoryService {

    JsonUtil viewAllCategory(PageUtils pageUtils);

    JsonUtil insertCategory(Category category);

    JsonUtil viewAllLevelOne();

    JsonUtil updateCategory(Category category);

    JsonUtil deleteCategoryById(Category category);
}