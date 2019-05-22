package com.springboot.mall.domain.vo;

public class ResponseVo
{
    String[] roles;
    String name;
    String[] perms;
    String avatar;

    public ResponseVo()
    {
    }

    public ResponseVo(String[] roles,String name,String[] perms,String avatar)
    {
        this.roles = roles;
        this.name = name;
        this.perms = perms;
        this.avatar = avatar;
    }

    public String[] getRoles()
    {
        return roles;
    }

    public void setRoles(String[] roles)
    {
        this.roles = roles;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String[] getPerms()
    {
        return perms;
    }

    public void setPerms(String[] perms)
    {
        this.perms = perms;
    }

    public String getAvatar()
    {
        return avatar;
    }

    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }
}
