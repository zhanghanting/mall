package com.springboot.mall.service.mallsmanagement.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.mall.domain.Brand;
import com.springboot.mall.mapper.BrandMapper;
import com.springboot.mall.service.mallsmanagement.BrandService;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.MallPageHelper;
import com.springboot.mall.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {


    @Autowired
    BrandMapper brandMapper;

    @Override
    public JsonUtil viewAllPageBrand(PageUtils pageUtils,Brand brand) {
        if(brand != null && brand.getName() != null){
            brand.setName("%" + brand.getName() + "%");
        }
        PageHelper.startPage(pageUtils.getPage(),pageUtils.getLimit());
        List<Brand> brands = brandMapper.viewAllBrand(pageUtils,brand);
        PageInfo pageInfo = new PageInfo(brands);
        MallPageHelper pageHelper = new MallPageHelper();
        pageHelper.setItems(brands);
        pageHelper.setTotal(pageInfo.getTotal());
        return new JsonUtil(pageHelper,0,"成功");
    }

    @Override
    public JsonUtil updateBrandById(Brand brand) {
        brandMapper.updateBrandById(brand);
        return new JsonUtil(brand,0,"成功");
    }

    @Override
    public JsonUtil deleteBrandById(Brand brand) {
        brandMapper.deleteBrandById(brand);
        return new JsonUtil(null,0,"成功");
    }

    @Override
    public JsonUtil insertBrand(Brand brand) {
        brandMapper.insertBrand(brand);
        brand = brandMapper.selectBrandByUrl(brand.getPicUrl());
        return new JsonUtil(brand,0,"OK");
    }
}
