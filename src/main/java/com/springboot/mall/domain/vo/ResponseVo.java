package com.springboot.mall.domain.vo;

public class ResponseVo
{
    String[] roles;
    String username;
    String[] perms;
    String avatar;
    String password;

    public ResponseVo()
    {
    }

    public ResponseVo(String[] roles,String username,String[] perms,String avatar,String password)
    {
        this.roles = roles;
        this.username = username;
        this.perms = perms;
        this.avatar = avatar;
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String[] getRoles()
    {
        return roles;
    }

    public void setRoles(String[] roles)
    {
        this.roles = roles;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
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
