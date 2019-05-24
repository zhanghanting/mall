package com.springboot.mall.service.systemManagement;

import com.springboot.mall.domain.Log;
import com.springboot.mall.utils.MyPageHelper;

import java.util.List;

public interface LogService
{
    //按格式返回分页数据
    MyPageHelper getList(int page,int limit,String sort,String order,String name);
    //按排序参数sort,排序方式order返回所有的log
    List<Log> getLogs(String sort,String order,String name);
}
