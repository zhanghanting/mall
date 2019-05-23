package com.springboot.mall.controller;

import com.springboot.mall.domain.vo.ResponseVo;
import com.springboot.mall.utils.JsonBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstController
{
    @ResponseBody
    @RequestMapping("/auth/login")
    public JsonBean login()
    {
        JsonBean jsonBean = new JsonBean();
        jsonBean.setErrno(0);
        jsonBean.setData(null);
        jsonBean.setErrmsg("成功");
        return jsonBean;
    }
    @ResponseBody
    @RequestMapping("/auth/info")
    public JsonBean info()
    {
        JsonBean jsonBean = new JsonBean();
        jsonBean.setErrno(0);
        jsonBean.setErrmsg("成功");
        ResponseVo responseVo = new ResponseVo();
        responseVo.setRoles(new String[]{"超级管理员"});
        responseVo.setName("admin123");
        responseVo.setPerms(new String[]{"*"});
        responseVo.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        jsonBean.setData(responseVo);
        return jsonBean;
    }
  /*  @ResponseBody
    @RequestMapping("/dashboard")
    public JsonBean dashboard()
    {
        JsonBean jsonUtil = new JsonBean();
        jsonUtil.setErrno(0);
        jsonUtil.setErrmsg("成功");

    }*/

}
