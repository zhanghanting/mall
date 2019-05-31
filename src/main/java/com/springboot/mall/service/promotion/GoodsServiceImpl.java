package com.springboot.mall.service.promotion;

import com.springboot.mall.domain.Goods;
import com.springboot.mall.domain.GoodsExample;
import com.springboot.mall.mapper.GoodsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/26 11:24
 */

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;


    /**
     * 获取某个商品信息,包含完整信息
     *
     * @param goodsId
     * @return
     */
    @Override
    public Goods findById(Integer goodsId) {
        GoodsExample example = new GoodsExample();
        example.or().andIdEqualTo(goodsId).andDeletedEqualTo(false);
        return goodsMapper.selectOneByExampleWithBLOBs(example);
    }
}
