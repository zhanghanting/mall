package com.springboot.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.mall.domain.SearchHistory;
import com.springboot.mall.mapper.SearchHistoryMapper;
import com.springboot.mall.service.SearchHistoryService;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.MallPageHelper;
import com.springboot.mall.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchHistoryServiceImpl implements SearchHistoryService {

    @Autowired
    SearchHistoryMapper searchHistoryMapper;

    @Override
    public JsonUtil queryAllSearchHistory(PageUtils pageUtils) {
        PageHelper.startPage(pageUtils.getPage(),pageUtils.getLimit());
        JsonUtil searchHistoryJsonBean = new JsonUtil();
        MallPageHelper searchHistoryData = new MallPageHelper();
        List<SearchHistory> searchHistories = searchHistoryMapper.queryAllSearchHistory(pageUtils);
        PageInfo<SearchHistory> pageInfo = new PageInfo<>(searchHistories);
        searchHistoryData.setItems(searchHistories);
        searchHistoryData.setTotal(pageInfo.getTotal());
        searchHistoryJsonBean.setData(searchHistoryData);
        searchHistoryJsonBean.setErrno(0);
        searchHistoryJsonBean.setErrmsg("成功");
        return searchHistoryJsonBean;
    }

}
