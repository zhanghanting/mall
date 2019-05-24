package com.springboot.mall.service.systemManagement;

import com.springboot.mall.domain.Admin;
import com.springboot.mall.utils.MyPageHelper;

import java.util.List;

public interface AdminService
{
    //按格式返回分页数据
    MyPageHelper getList(int page,int limit,String sort,String order);
    //按排序参数sort,排序方式order返回所有的admin
    List<Admin> getAdmins(String sort,String order);
}
