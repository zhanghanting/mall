package com.springboot.mall.utils;

public class JsonUtil
{
    //响应数据
    private Object data;
    //响应状态
    private Integer errno;
    //响应消息
    private String errmsg;

    public JsonUtil()
    {
    }

    public JsonUtil(Object data,Integer errno,String errmsg)
    {
        this.data = data;
        this.errno = errno;
        this.errmsg = errmsg;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }

    public Integer getErrno()
    {
        return errno;
    }

    public void setErrno(Integer errno)
    {
        this.errno = errno;
    }

    public String getErrmsg()
    {
        return errmsg;
    }

    public void setErrmsg(String errmsg)
    {
        this.errmsg = errmsg;
    }
}
