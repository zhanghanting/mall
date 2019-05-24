package com.springboot.mall.service.impl;

import com.springboot.mall.domain.vo.RegionVo;
import com.springboot.mall.mapper.RegionVoMapper;
import com.springboot.mall.service.RegionService;
import com.springboot.mall.utils.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    RegionVoMapper regionVoMapper;

    @Override
    public JsonBean viewAllRegoin() {

        List<RegionVo> regionVosFirst = regionVoMapper.viewAllRegionVos(10, 100);
        for (RegionVo regionVo : regionVosFirst) {
            regionVo.setChildren(regionVoMapper.viewAllRegionVos(regionVo.getCode()*100,regionVo.getCode()*100+99));
            List<RegionVo> children = regionVo.getChildren();
            for (RegionVo child : children) {
                child.setChildren(regionVoMapper.viewAllRegionVos(child.getCode()*100,child.getCode()*100+99));
            }
        }
        return new JsonBean(regionVosFirst,0,"成功");
    }
}
