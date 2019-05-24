package com.springboot.mall.mapper;

import com.springboot.mall.domain.Category;
import com.springboot.mall.domain.CategoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper {
    List<Category> viewAllCategory();
}