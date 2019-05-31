package com.springboot.mall.controller;

import com.springboot.mall.domain.vo.ResponseVo;
import com.springboot.mall.service.login.LoginService;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RequestMapping("/admin")
@Controller
public class FirstController
{
    @Autowired
    LoginService loginService;
    @ResponseBody
    @RequestMapping("/auth/login")
    public JsonUtil login(@RequestBody ResponseVo responseVo,HttpServletRequest request)
    {
        /*JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setErrno(0);
        jsonUtil.setData(null);
        jsonUtil.setErrmsg("成功");*/
        responseVo.setPassword(Md5Util.getMd5(responseVo.getPassword()));
        HashMap map = (HashMap)request.getServletContext().getAttribute("map");
        JsonUtil jsonUtil = loginService.login(responseVo,map);
        return jsonUtil;
    }
    @ResponseBody
    @RequestMapping("/auth/info")
    public JsonUtil info(String token,HttpServletRequest request)
    {
        /*JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setErrno(0);
        jsonUtil.setErrmsg("成功");
        ResponseVo responseVo = new ResponseVo();
        responseVo.setRoles(new String[]{"超级管理员"});
        responseVo.setName("admin123");
        responseVo.setPerms(new String[]{"*"});
        responseVo.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        jsonUtil.setData(responseVo);*/

        JsonUtil jsonUtil = new JsonUtil();
        HashMap map = (HashMap)request.getServletContext().getAttribute("map");
        Object adminInfo = map.get(token);
        if(adminInfo != null)
        {
            jsonUtil.setData(adminInfo);
            jsonUtil.setErrno(0);
            jsonUtil.setErrmsg("成功");
        }
        return jsonUtil;
    }
}
