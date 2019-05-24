package com.springboot.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.mall.domain.Brand;
import com.springboot.mall.mapper.BrandMapper;
import com.springboot.mall.service.BrandService;
import com.springboot.mall.utils.JsonBean;
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
    public JsonBean viewAllPageBrand(PageUtils pageUtils,Brand brand) {
        if(brand != null && brand.getName() != null){
            brand.setName("%" + brand.getName() + "%");
        }
        PageHelper.startPage(pageUtils.getPage(),pageUtils.getLimit());
        List<Brand> brands = brandMapper.viewAllBrand(pageUtils,brand);
        PageInfo pageInfo = new PageInfo(brands);
        MallPageHelper pageHelper = new MallPageHelper();
        pageHelper.setItems(brands);
        pageHelper.setTotal(pageInfo.getTotal());
        return new JsonBean(pageHelper,0,"成功");
    }

    @Override
    public JsonBean updateBrandById(Brand brand) {
        brandMapper.updateBrandById(brand);
        return new JsonBean(brand,0,"成功");
    }

    @Override
    public JsonBean deleteBrandById(Brand brand) {
        brandMapper.deleteBrandById(brand);
        return new JsonBean(null,0,"成功");
    }

    @Override
    public JsonBean insertBrand(Brand brand) {
        brandMapper.insertBrand(brand);
        brand = brandMapper.selectBrandByUrl(brand.getPicUrl());
        return new JsonBean(brand,0,"OK");
    }
}
