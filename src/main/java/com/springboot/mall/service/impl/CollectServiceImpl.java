package com.springboot.mall.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.mall.domain.Collect;
import com.springboot.mall.mapper.CollectMapper;
import com.springboot.mall.service.CollectService;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.MallPageHelper;
import com.springboot.mall.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    CollectMapper collectMapper;

    @Override
    public JsonUtil queryAllCollect(PageUtils pageUtils) {
        PageHelper.startPage(pageUtils.getPage(),pageUtils.getLimit());
        JsonUtil collectJsonUtil = new JsonUtil();
        MallPageHelper collectData = new MallPageHelper();
        List<Collect> collects = collectMapper.queryAllCollect(pageUtils);
        PageInfo<Collect> pageInfo = new PageInfo<>(collects);
        collectData.setItems(collects);
        collectData.setTotal(pageInfo.getTotal());
        collectJsonUtil.setData(collectData);
        collectJsonUtil.setErrno(0);
        collectJsonUtil.setErrmsg("成功");
        return collectJsonUtil;
    }
}
