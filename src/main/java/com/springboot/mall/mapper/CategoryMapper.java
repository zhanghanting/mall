package com.springboot.mall.mapper;

import com.springboot.mall.domain.Category;
import com.springboot.mall.domain.CategoryExample;
import com.springboot.mall.domain.vo.CategoryVo;
import com.springboot.mall.domain.vo.LevelOne;
import com.springboot.mall.utils.JsonUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper {
    List<CategoryVo> viewAllCategories();

    int insertCategory(@Param("category") Category category);

    List<LevelOne> viewAllLevelOne();


    int updateCategory(@Param("category") Category category);

    int deleteCategoryById(@Param("category") Category category);

}