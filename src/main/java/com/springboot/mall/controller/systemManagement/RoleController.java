package com.springboot.mall.controller.systemManagement;

import com.springboot.mall.domain.Role;
import com.springboot.mall.service.systemManagement.RoleService;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
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
    @RequestMapping(value = "/role/create",method = RequestMethod.POST)
    public JsonUtil add(Role role)
    {
        JsonUtil jsonUtil = new JsonUtil();
        Role role1 = roleService.add(role);
        jsonUtil.setData(role1);
        jsonUtil.setErrno(0);
        jsonUtil.setErrmsg("成功");
        return jsonUtil;
    }
}
