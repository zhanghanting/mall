package com.springboot.mall.domain.vo;

import com.springboot.mall.domain.Admin;

public class AdminVo extends Admin
{
    String roleName;//角色名

    public String getRoleName()
    {
        return roleName;
    }

    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }
}
