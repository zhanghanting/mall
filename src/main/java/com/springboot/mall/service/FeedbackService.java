package com.springboot.mall.service;

import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.PageUtils;

public interface FeedbackService {
    public JsonUtil queryAllFeedback(PageUtils pageUtils);
}
