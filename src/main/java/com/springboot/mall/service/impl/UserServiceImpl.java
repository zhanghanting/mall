package com.springboot.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.mall.domain.User;
import com.springboot.mall.mapper.UserMapper;
import com.springboot.mall.service.UserService;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.MallPageHelper;
import com.springboot.mall.utils.UserPageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public JsonUtil queryAllUser(UserPageUtils userPageUtils) {
        PageHelper.startPage(userPageUtils.getPage(),userPageUtils.getLimit());
        JsonUtil userJsonUtil = new JsonUtil();
        MallPageHelper userData = new MallPageHelper();
        List<User> users = userMapper.queryAllUser(userPageUtils);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        userData.setItems(users);
        userData.setTotal(pageInfo.getTotal());
        userJsonUtil.setData(userData);
        userJsonUtil.setErrno(0);
        userJsonUtil.setErrmsg("成功");
        return userJsonUtil;
    }
}
