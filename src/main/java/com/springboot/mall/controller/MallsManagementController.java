package com.springboot.mall.controller;

import com.springboot.mall.domain.Brand;
import com.springboot.mall.service.BrandService;
import com.springboot.mall.service.RegionService;
import com.springboot.mall.utils.JsonBean;
import com.springboot.mall.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MallsManagementController {

    @Autowired
    RegionService regionService;

    @Autowired
    BrandService brandService;

    @RequestMapping("/region/list")
    public JsonBean regionList(){
        return regionService.viewAllRegoin();
    }


    @RequestMapping("/brand/list")
    public JsonBean brandList(PageUtils pageUtils,Brand brand){
        return brandService.viewAllPageBrand(pageUtils,brand);
    }

    @RequestMapping("/brand/create")
    public JsonBean brandCreate(@RequestBody Brand brand){
        return brandService.insertBrand(brand);
    }

    @RequestMapping("/brand/delete")
    public JsonBean brandDelete(@RequestBody Brand brand){
        return brandService.deleteBrandById(brand);
    }

    @RequestMapping("/brand/update")
    public JsonBean brandUpdate(@RequestBody Brand brand){
        return brandService.updateBrandById(brand);
    }


}
