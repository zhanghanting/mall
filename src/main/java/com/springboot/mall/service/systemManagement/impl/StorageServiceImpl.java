package com.springboot.mall.service.systemManagement.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.mall.domain.Storage;
import com.springboot.mall.mapper.StorageMapper;
import com.springboot.mall.service.systemManagement.StorageService;
import com.springboot.mall.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StorageServiceImpl implements StorageService
{
    @Autowired
    StorageMapper storageMapper;
    @Override
    public MyPageHelper getList(int page,int limit,String sort,String order,String key,String name)
    {
        PageHelper.startPage(page,limit);
        List<Storage> storage = getStorage(sort,order,key,name);
        PageInfo<Storage> logPageInfo = new PageInfo<>(storage);
        MyPageHelper pageHelper = new MyPageHelper();
        pageHelper.setItems(storage);
        pageHelper.setTotal(logPageInfo.getTotal());
        return pageHelper;
    }

    @Override
    public List<Storage> getStorage(String sort,String order,String key,String name)
    {
        List<Storage> storage =storageMapper.getStorage(sort,order,key,name);
        return storage;
    }
    //更新
    @Override
    public Storage update(Storage storage)
    {
        int update = storageMapper.update(storage);
        if(update > 0)
        {
            return storage;
        }
        else
            return null;
    }

    @Override
    public int delete(Storage storage)
    {
        int i = storageMapper.deleteByPrimaryKey(storage.getId());
        return i;
    }
}
