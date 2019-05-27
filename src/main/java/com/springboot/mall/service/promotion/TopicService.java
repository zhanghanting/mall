package com.springboot.mall.service.promotion;

import com.springboot.mall.domain.Topic;

import java.util.List;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/26 10:45
 */

public interface TopicService {
    List<Topic> querySelective(String title, String subtitle, Integer page, Integer limit, String sort, String order);

    void add(Topic topic);

    Topic findById(Integer id);

    int updateById(Topic topic);

    void deleteById(Integer id);
}
