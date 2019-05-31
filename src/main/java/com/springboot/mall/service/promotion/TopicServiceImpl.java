package com.springboot.mall.service.promotion;

import com.github.pagehelper.PageHelper;
import com.springboot.mall.domain.Topic;
import com.springboot.mall.domain.TopicExample;
import com.springboot.mall.mapper.TopicMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/26 10:46
 */
@Service
public class TopicServiceImpl implements TopicService {

    @Resource
    private TopicMapper topicMapper;

    @Override
    public List<Topic> querySelective(String title, String subtitle, Integer page, Integer limit, String sort, String order) {
        TopicExample example = new TopicExample();
        TopicExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(title)) {
            criteria.andTitleLike("%" + title + "%");
        }
        if (!StringUtils.isEmpty(subtitle)) {
            criteria.andSubtitleLike("%" + subtitle + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return topicMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public void add(Topic topic) {
        topic.setAddTime(new Date());
        topic.setUpdateTime(new Date());
        topicMapper.insertSelective(topic);
    }

    @Override
    public Topic findById(Integer id) {
        return topicMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateById(Topic topic) {
        topic.setUpdateTime(new Date());
        TopicExample example = new TopicExample();
        example.or().andIdEqualTo(topic.getId());
        return topicMapper.updateByExampleSelective(topic, example);
    }

    @Override
    public void deleteById(Integer id) {
        topicMapper.deleteByPrimaryKey(id);
    }
}
