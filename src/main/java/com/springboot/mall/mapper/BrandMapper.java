package com.springboot.mall.mapper;

import com.springboot.mall.domain.Brand;
import com.springboot.mall.domain.BrandExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {
    long countByExample(BrandExample example);

    int deleteByExample(BrandExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Brand record);

    int insertSelective(Brand record);

    List<Brand> selectByExample(BrandExample example);

    Brand selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Brand record,@Param("example") BrandExample example);

    int updateByExample(@Param("record") Brand record,@Param("example") BrandExample example);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);
}