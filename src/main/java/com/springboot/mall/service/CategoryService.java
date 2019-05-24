package com.springboot.mall.service;

import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.PageUtils;

public interface CategoryService {

    JsonUtil viewAllCategory(PageUtils pageUtils);
}
