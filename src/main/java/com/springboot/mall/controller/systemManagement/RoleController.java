package com.springboot.mall.controller.systemManagement;

import com.springboot.mall.domain.Role;
import com.springboot.mall.service.systemManagement.RoleService;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.MyPageHelper;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/admin")
public class RoleController
{
    @Autowired
    RoleService roleService;
    @ResponseBody
    @RequestMapping("/role/list")
    public JsonUtil getRoles(int page,int limit,String sort,String order,String name)
    {
        JsonUtil jsonUtil = new JsonUtil();
        MyPageHelper list = roleService.getList(page,limit,sort,order,name);
        jsonUtil.setData(list);
        jsonUtil.setErrno(0);
        jsonUtil.setErrmsg("成功");
        return jsonUtil;
    }
    @ResponseBody
    @RequestMapping(value = "/role/create")
    public JsonUtil add(@RequestBody Role role)
    {
        JsonUtil jsonUtil = new JsonUtil();
        Role role1 = roleService.add(role);
        jsonUtil.setData(role1);
        jsonUtil.setErrno(0);
        jsonUtil.setErrmsg("成功");
        return jsonUtil;
    }
    @ResponseBody
    @RequestMapping(value = "role/update")
    public JsonUtil update(@RequestBody Role role)
    {
        JsonUtil jsonUtil = roleService.update(role);
        return jsonUtil;
    }
    @ResponseBody
    @RequestMapping("/role/delete")
    public JsonUtil delete(@RequestBody Role role)
    {
        JsonUtil jsonUtil = roleService.delete(role);
        return jsonUtil;
    }

}
