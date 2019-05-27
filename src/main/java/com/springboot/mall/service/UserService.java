package com.springboot.mall.service;

import com.springboot.mall.utils.JsonBean;
import com.springboot.mall.utils.UserPageUtils;


public interface UserService {

    public JsonBean queryAllUser(UserPageUtils userPageUtils);
}
