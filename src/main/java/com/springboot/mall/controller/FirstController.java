package com.springboot.mall.controller;

import com.springboot.mall.domain.vo.ResponseVo;
import com.springboot.mall.utils.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class FirstController
{
    @ResponseBody
    @RequestMapping("/auth/login")
    public JsonUtil login()
    {
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setErrno(0);
        jsonUtil.setData(null);
        jsonUtil.setErrmsg("成功");
        return jsonUtil;
    }
    @ResponseBody
    @RequestMapping("/auth/info")
    public JsonUtil info()
    {
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setErrno(0);
        jsonUtil.setErrmsg("成功");
        ResponseVo responseVo = new ResponseVo();
        responseVo.setRoles(new String[]{"超级管理员"});
        responseVo.setName("admin123");
        responseVo.setPerms(new String[]{"*"});
        responseVo.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        jsonUtil.setData(responseVo);
        return jsonUtil;
    }
  /*  @ResponseBody
    @RequestMapping("/dashboard")
    public JsonUtil dashboard()
    {
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setErrno(0);
        jsonUtil.setErrmsg("成功");

    }*/

}
