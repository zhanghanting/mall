package com.springboot.mall.service;

import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.UserPageUtils;


public interface UserService {

    public JsonUtil queryAllUser(UserPageUtils userPageUtils);
}
