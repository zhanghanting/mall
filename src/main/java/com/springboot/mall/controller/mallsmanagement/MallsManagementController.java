package com.springboot.mall.controller.mallsmanagement;

import com.springboot.mall.domain.Brand;
import com.springboot.mall.service.mallsmanagement.BrandService;
import com.springboot.mall.service.mallsmanagement.RegionService;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MallsManagementController {

    @Autowired
    RegionService regionService;

    @Autowired
    BrandService brandService;

    @RequestMapping("/region/list")
    public JsonUtil regionList(){
        return regionService.viewAllRegoin();
    }


    @RequestMapping("/brand/list")
    public JsonUtil brandList(PageUtils pageUtils,Brand brand){
        return brandService.viewAllPageBrand(pageUtils,brand);
    }

    @RequestMapping("/brand/create")
    public JsonUtil brandCreate(@RequestBody Brand brand){
        return brandService.insertBrand(brand);
    }

    @RequestMapping("/brand/delete")
    public JsonUtil brandDelete(@RequestBody Brand brand){
        return brandService.deleteBrandById(brand);
    }

    @RequestMapping("/brand/update")
    public JsonUtil brandUpdate(@RequestBody Brand brand){
        return brandService.updateBrandById(brand);
    }


}
