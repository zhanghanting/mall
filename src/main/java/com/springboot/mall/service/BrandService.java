package com.springboot.mall.service;

import com.springboot.mall.domain.Brand;
import com.springboot.mall.utils.JsonBean;
import com.springboot.mall.utils.PageUtils;

public interface BrandService {
    JsonBean viewAllPageBrand(PageUtils pageUtils,Brand brand);

    JsonBean updateBrandById(Brand brand);

    JsonBean deleteBrandById(Brand brand);

    JsonBean insertBrand(Brand brand);
}
