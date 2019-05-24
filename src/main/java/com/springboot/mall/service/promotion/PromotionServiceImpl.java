package com.springboot.mall.service.promotion;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.mall.domain.Ad;
import com.springboot.mall.domain.AdExample;
import com.springboot.mall.mapper.AdMapper;
import com.springboot.mall.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/23 21:04
 */

@Service
public class PromotionServiceImpl implements PromotionService {

    @Autowired
    AdMapper adMapper;


    @Override
    public MyPageHelper getList(Integer page, Integer rows, String sort, String order) {


        PageHelper.startPage(1,20);
        //AdExample adExample = new AdExample();
        //List<Ad> ads = adMapper.selectByExample(adExample);

        List<Ad> ads = adMapper.selectAllAd();

        MyPageHelper result = new MyPageHelper();
        result.setItems(ads);

        PageInfo<Ad> pageInfo = new PageInfo<>(ads);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
