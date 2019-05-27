package com.springboot.mall.mapper;

import com.springboot.mall.domain.Collect;
import com.springboot.mall.domain.SearchHistory;
import com.springboot.mall.domain.SearchHistoryExample;
import com.springboot.mall.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SearchHistoryMapper {
    long countByExample(SearchHistoryExample example);

    int deleteByExample(SearchHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SearchHistory record);

    int insertSelective(SearchHistory record);

    List<SearchHistory> selectByExample(SearchHistoryExample example);

    SearchHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SearchHistory record,@Param("example") SearchHistoryExample example);

    int updateByExample(@Param("record") SearchHistory record,@Param("example") SearchHistoryExample example);

    int updateByPrimaryKeySelective(SearchHistory record);

    int updateByPrimaryKey(SearchHistory record);

    List<SearchHistory> queryAllSearchHistory(PageUtils pageUtils);
}