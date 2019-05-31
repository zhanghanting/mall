package com.springboot.mall.controller.mallsmanagement;

import com.springboot.mall.domain.Category;
import com.springboot.mall.service.mallsmanagement.CategoryService;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/list")
    public JsonUtil list(PageUtils pageUtils){
        return categoryService.viewAllCategory(pageUtils);
    }

    @RequestMapping("/create")
    public JsonUtil create(@RequestBody Category category){
        return categoryService.insertCategory(category);
    }



    @RequestMapping("/update")
    public JsonUtil update(@RequestBody Category category){
        return categoryService.updateCategory(category);
    }

    @RequestMapping("/delete")
    public JsonUtil delete(@RequestBody Category category){
        return categoryService.deleteCategoryById(category);
    }

    @RequestMapping("/l1")
    public JsonUtil l1(){
        return categoryService.viewAllLevelOne();
    }
}
