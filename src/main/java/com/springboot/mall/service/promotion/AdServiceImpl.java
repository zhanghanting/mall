package com.springboot.mall.service.promotion;

import com.github.pagehelper.PageHelper;
import com.springboot.mall.domain.Ad;
import com.springboot.mall.domain.AdExample;
import com.springboot.mall.mapper.AdMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/24 17:09
 */

@Service
public class AdServiceImpl implements AdService {


    @Resource
    AdMapper adMapper;

    @Override
    public List<Ad> querySelective(String name, String content, Integer page, Integer limit, String sort, String order) {
        AdExample adExample = new AdExample();
        AdExample.Criteria criteria = adExample.createCriteria();

        //广告标题不为空
        if (!StringUtils.isEmpty(name)){
            criteria.andNameLike("%" + name + "%");
        }

        //广告内容不为空
        if (!StringUtils.isEmpty(content)){
            criteria.andNameLike("%" + content + "%");
        }

        criteria.andDeletedEqualTo(false);

        //排序不为空
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            adExample.setOrderByClause(sort + " " + order);
        }

//        //分页处理
//        PageHelper.startPage(page,limit);
//        List<Ad> adList = adMapper.selectByExample(adExample);
//
//        //创建一个返回值对象
//        MyPageHelper result = new MyPageHelper();
//        result.setItems(adList);
//
//        //取总记录数
//        PageInfo<Ad> pageInfo = new PageInfo<>(adList);
//        result.setTotal(pageInfo.getTotal());
//
//        return adList;

        PageHelper.startPage(page, limit);
        return adMapper.selectByExample(adExample);
    }

    @Override
    public void deleteById(Integer id) {
        adMapper.deleteById(id);
    }

    @Override
    public int updateById(Ad ad) {
        ad.setUpdateTime(new Date());
        return adMapper.updateByPrimaryKeySelective(ad);
    }

    @Override
    public void add(Ad ad) {
        ad.setAddTime(new Date());
        ad.setUpdateTime(new Date());
        adMapper.insertSelective(ad);
    }
}
