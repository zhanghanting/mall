package com.springboot.mall.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.mall.domain.Feedback;
import com.springboot.mall.mapper.FeedbackMapper;
import com.springboot.mall.service.FeedbackService;
import com.springboot.mall.utils.JsonBean;
import com.springboot.mall.utils.MallPageHelper;
import com.springboot.mall.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    FeedbackMapper feedbackMapper;

    @Override
    public JsonBean queryAllFeedback(PageUtils pageUtils) {
        PageHelper.startPage(pageUtils.getPage(),pageUtils.getLimit());
        JsonBean feedbackJsonBean = new JsonBean();
        MallPageHelper feedbackData = new MallPageHelper();
        List<Feedback> feedbacks = feedbackMapper.queryAllFeedback(pageUtils);
        PageInfo<Feedback> pageInfo = new PageInfo<>(feedbacks);
        feedbackData.setItems(feedbacks);
        feedbackData.setTotal(pageInfo.getTotal());
        feedbackJsonBean.setData(feedbackData);
        feedbackJsonBean.setErrno(0);
        feedbackJsonBean.setErrmsg("成功");
        return feedbackJsonBean;
    }
}
