package com.springboot.mall.utils;

import com.github.pagehelper.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/24 16:44
 */

/*
     响应操作结果
     {
        errno: 错误码
        errmsg: 错误消息
        data: 响应数据
     }
 */
public class ResponseUtil {
    public static Object ok(){
        Map<String,Object> obj = new HashMap<>();
        obj.put("errno",0);
        obj.put("errmsg","成功");
        return obj;
    }

    public static Object ok(Object data){
        Map<String,Object> obj = new HashMap<>();
        obj.put("errno",0);
        obj.put("errmsg","成功");
        obj.put("data",data);
        return obj;
    }

    public static Object okList(List list){
        Map<String,Object> data = new HashMap<>();
        data.put("items",list);

        if (list instanceof Page){
            Page page = (Page) list;
            data.put("total",page.getTotal());
//            data.put("page",page.getPageNum());
//            data.put("limit",page.getPageSize());
//            data.put("pages",page.getPages());
        } else {
            data.put("total",list.size());
//            data.put("page",1);
//            data.put("items",list.size());
//            data.put("pages",1);
        }
        return ok(data);
    }


    public static Object okList(List list, List pagedList) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("list", list);

        if (pagedList instanceof Page) {
            Page page = (Page) pagedList;
            data.put("total", page.getTotal());
//            data.put("page", page.getPageNum());
//            data.put("limit", page.getPageSize());
//            data.put("pages", page.getPages());
        }
        else{
            data.put("total", pagedList.size());
//            data.put("page", 1);
//            data.put("limit", pagedList.size());
//            data.put("pages", 1);
        }
        return ok(data);
    }


    public static Object fail(){
        Map<String,Object> obj = new HashMap<>();
        obj.put("errno",-1);
        obj.put("errmsg","错误");
        return obj;
    }

    public static Object fail(int errno, String errmsg){
        Map<String,Object> obj = new HashMap<>();
        obj.put("errno",errno);
        obj.put("errmsg",errmsg);
        return obj;
    }


    public static Object badArgument() {
        return fail(401, "参数不对");
    }

    public static Object badArgumentValue() {
        return fail(402, "参数值不对");
    }

    public static Object updatedDataFailed() {
        return fail(505, "更新数据失败");
    }


}
