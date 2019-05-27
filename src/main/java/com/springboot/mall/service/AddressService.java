package com.springboot.mall.service;

import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.PageUtils;

public interface AddressService {
    JsonUtil queryAllAddress(PageUtils pageUtils);
}
