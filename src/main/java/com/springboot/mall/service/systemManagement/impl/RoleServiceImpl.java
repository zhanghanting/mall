package com.springboot.mall.service.systemManagement.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.mall.domain.Role;
import com.springboot.mall.mapper.RoleMapper;
import com.springboot.mall.service.systemManagement.RoleService;
import com.springboot.mall.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService
{
    @Autowired
    RoleMapper roleMapper;
    @Override
    public MyPageHelper getList(int page,int limit,String sort,String order,String name)
    {
        PageHelper.startPage(page,limit);
        List<Role> roles = getRoles(sort,order,name);
        PageInfo<Role> logPageInfo = new PageInfo<>(roles);
        MyPageHelper pageHelper = new MyPageHelper();
        pageHelper.setItems(roles);
        pageHelper.setTotal(logPageInfo.getTotal());
        return pageHelper;
    }

    @Override
    public List<Role> getRoles(String sort,String order,String name)
    {
        List<Role> roles = roleMapper.getRoles(sort,order,name);
        return roles;
    }

    @Override
    public Role add(Role role)
    {
        int num = roleMapper.add(role);
        if(num > 0)
            return role;
        else
            return null;
    }
}
