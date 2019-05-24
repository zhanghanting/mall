package com.springboot.mall.service.systemManagement.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.mall.domain.Admin;
import com.springboot.mall.domain.vo.AdminVo;
import com.springboot.mall.mapper.AdminMapper;
import com.springboot.mall.service.systemManagement.AdminService;
import com.springboot.mall.utils.MyPageHelper;
import com.springboot.mall.utils.StringToIntArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService
{
    @Autowired
    AdminMapper adminMapper;
    /**
     *
     * @param page
     * @param limit
     * @param sort 表示按sort参数进行排序
     * @param order 表示升序还是降序
     * @return
     */
    @Override
    public MyPageHelper getList(int page,int limit,String sort,String order)
    {
        PageHelper.startPage(page,limit);
        List<Admin> admins = getAdmins(sort,order);
        PageInfo<Admin> adminPageInfo = new PageInfo<>(admins);
        MyPageHelper pageHelper = new MyPageHelper();
        pageHelper.setItems(admins);
        pageHelper.setTotal(adminPageInfo.getTotal());
        return pageHelper;
    }

    @Override
    public List<Admin> getAdmins(String sort,String order)
    {
        List<Admin> admins = adminMapper.getAdmins(sort,order);
        return admins;
    }
}
