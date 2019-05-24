package com.springboot.mall.controller;

import com.springboot.mall.domain.Category;
import com.springboot.mall.service.CategoryService;
import com.springboot.mall.utils.JsonBean;
import com.springboot.mall.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/list")
    public JsonBean list(PageUtils pageUtils){
        return categoryService.viewAllCategory(pageUtils);
    }
}
