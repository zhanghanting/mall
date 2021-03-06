package com.springboot.mall.service.mallsmanagement.impl;

import com.springboot.mall.domain.vo.RegionVo;
import com.springboot.mall.mapper.RegionVoMapper;
import com.springboot.mall.service.mallsmanagement.RegionService;
import com.springboot.mall.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    RegionVoMapper regionVoMapper;

    @Override
    public JsonUtil viewAllRegoin() {

        List<RegionVo> regionVosFirst = regionVoMapper.viewAllRegionVos(10, 100);
        for (RegionVo regionVo : regionVosFirst) {
            regionVo.setChildren(regionVoMapper.viewAllRegionVos(regionVo.getCode()*100,regionVo.getCode()*100+99));
            List<RegionVo> children = regionVo.getChildren();
            for (RegionVo child : children) {
                child.setChildren(regionVoMapper.viewAllRegionVos(child.getCode()*100,child.getCode()*100+99));
            }
        }
        return new JsonUtil(regionVosFirst,0,"成功");
    }
}
