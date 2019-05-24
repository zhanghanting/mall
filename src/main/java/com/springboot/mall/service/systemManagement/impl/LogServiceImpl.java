package com.springboot.mall.service.systemManagement.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.mall.domain.Log;
import com.springboot.mall.mapper.LogMapper;
import com.springboot.mall.service.systemManagement.LogService;
import com.springboot.mall.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LogServiceImpl implements LogService
{
    @Autowired
    LogMapper logMapper;
    @Override
    public MyPageHelper getList(int page,int limit,String sort,String order,String name)
    {
        PageHelper.startPage(page,limit);
        List<Log> logs = getLogs(sort,order,name);
        PageInfo<Log> logPageInfo = new PageInfo<>(logs);
        MyPageHelper pageHelper = new MyPageHelper();
        pageHelper.setItems(logs);
        pageHelper.setTotal(logPageInfo.getTotal());
        return pageHelper;
    }

    @Override
    public List<Log> getLogs(String sort,String order,String name)
    {
        if(name != null)
        {
            name = name.trim();
        }
        List<Log> logs = logMapper.getLogs(sort,order,name);
        return logs;
    }
}
