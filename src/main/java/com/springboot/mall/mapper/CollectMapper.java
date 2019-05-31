package com.springboot.mall.mapper;

import com.springboot.mall.domain.Address;
import com.springboot.mall.domain.Collect;
import com.springboot.mall.domain.CollectExample;
import com.springboot.mall.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectMapper {
    long countByExample(CollectExample example);

    int deleteByExample(CollectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Collect record);

    int insertSelective(Collect record);

    List<Collect> selectByExample(CollectExample example);

    Collect selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Collect record, @Param("example") CollectExample example);

    int updateByExample(@Param("record") Collect record, @Param("example") CollectExample example);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);

    List<Collect> queryAllCollect(PageUtils pageUtils);
}