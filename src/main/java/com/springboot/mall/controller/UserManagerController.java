package com.springboot.mall.controller;

import com.springboot.mall.service.UserService;
import com.springboot.mall.service.impl.UserServiceImpl;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.UserPageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserManagerController {

    @Autowired
    UserService userService = new UserServiceImpl();

    @ResponseBody
    @RequestMapping("/user/list")
    public JsonUtil userList(UserPageUtils userPageUtils){

        JsonUtil userList = userService.queryAllUser(userPageUtils);
        return userList;
    }
}
