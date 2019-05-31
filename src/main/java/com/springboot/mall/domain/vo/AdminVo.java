package com.springboot.mall.domain.vo;

import com.springboot.mall.domain.Admin;

public class AdminVo
{
    private String id;
    private String username;
    private String avatar;
    private int[] roleIds;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getAvatar()
    {
        return avatar;
    }

    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

    public int[] getRoleIds()
    {
        return roleIds;
    }

    public void setRoleIds(int[] roleIds)
    {
        this.roleIds = roleIds;
    }
}
