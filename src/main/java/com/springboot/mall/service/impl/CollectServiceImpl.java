package com.springboot.mall.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.mall.domain.Collect;
import com.springboot.mall.mapper.CollectMapper;
import com.springboot.mall.service.CollectService;
import com.springboot.mall.utils.JsonBean;
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
    public JsonBean queryAllCollect(PageUtils pageUtils) {
        PageHelper.startPage(pageUtils.getPage(),pageUtils.getLimit());
        JsonBean collectJsonBean = new JsonBean();
        MallPageHelper collectData = new MallPageHelper();
        List<Collect> collects = collectMapper.queryAllCollect(pageUtils);
        PageInfo<Collect> pageInfo = new PageInfo<>(collects);
        collectData.setItems(collects);
        collectData.setTotal(pageInfo.getTotal());
        collectJsonBean.setData(collectData);
        collectJsonBean.setErrno(0);
        collectJsonBean.setErrmsg("成功");
        return collectJsonBean;
    }
}
