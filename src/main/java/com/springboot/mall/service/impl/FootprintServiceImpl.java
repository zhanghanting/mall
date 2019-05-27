package com.springboot.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.mall.domain.Collect;
import com.springboot.mall.mapper.FootprintMapper;
import com.springboot.mall.service.FootprintService;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.MallPageHelper;
import com.springboot.mall.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootprintServiceImpl implements FootprintService {

    @Autowired
    FootprintMapper footprintMapper;

    @Override
    public JsonUtil queryAllFootprint(PageUtils pageUtils) {

            PageHelper.startPage(pageUtils.getPage(),pageUtils.getLimit());
        JsonUtil footprintJsonBean = new JsonUtil();
            MallPageHelper footprintData = new MallPageHelper();
            List<Collect> collects = footprintMapper.queryAllFootprint(pageUtils);
            PageInfo<Collect> pageInfo = new PageInfo<>(collects);
        footprintData.setItems(collects);
        footprintData.setTotal(pageInfo.getTotal());
        footprintJsonBean.setData(footprintData);
        footprintJsonBean.setErrno(0);
        footprintJsonBean.setErrmsg("成功");
            return footprintJsonBean;
        }

}
