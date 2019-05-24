package com.springboot.mall.mapper;

import com.springboot.mall.domain.vo.RegionVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RegionVoMapper {

    @Select("select * from cskaoyan_mall_region where code > #{start} and code < #{end}")
    List<RegionVo> viewAllRegionVos(@Param("start")int start,
                                    @Param("end")int end);
}
