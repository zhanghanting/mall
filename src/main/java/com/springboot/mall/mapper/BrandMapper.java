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

    Brand selectBrandByUrl(@Param("picUrl") String picUrl);
}