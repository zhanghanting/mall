package com.springboot.mall.service;

import com.springboot.mall.utils.JsonBean;
import com.springboot.mall.utils.PageUtils;

public interface FeedbackService {
    public JsonBean queryAllFeedback(PageUtils pageUtils);
}
