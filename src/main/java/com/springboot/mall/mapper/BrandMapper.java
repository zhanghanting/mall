package com.springboot.mall.mapper;

import com.springboot.mall.domain.Brand;
import com.springboot.mall.domain.BrandExample;
import com.springboot.mall.utils.PageUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BrandMapper {

    List<Brand> viewAllBrand(@Param("pageUtils") PageUtils pageUtils,@Param("brand") Brand brand);

    int updateBrandById(@Param("brand") Brand brand);

    int deleteBrandById(@Param("brand") Brand brands);

    int insertBrand(@Param("brand") Brand brand);

<<<<<<< HEAD
    List<Brand> selectByExample(BrandExample example);

    Brand selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Brand record, @Param("example") BrandExample example);

    int updateByExample(@Param("record") Brand record, @Param("example") BrandExample example);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);
=======
    Brand selectBrandByUrl(@Param("picUrl") String picUrl);
>>>>>>> 137c57c3173242ce170d83b2eed992c1acd9ee70
}