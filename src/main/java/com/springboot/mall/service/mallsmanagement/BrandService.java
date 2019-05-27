package com.springboot.mall.service.mallsmanagement;

import com.springboot.mall.domain.Brand;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.PageUtils;

public interface BrandService {
    JsonUtil viewAllPageBrand(PageUtils pageUtils,Brand brand);

    JsonUtil updateBrandById(Brand brand);

    JsonUtil deleteBrandById(Brand brand);

    JsonUtil insertBrand(Brand brand);
}
