package com.springboot.mall.controller;


import com.springboot.mall.service.FeedbackService;
import com.springboot.mall.service.impl.FeedbackServiceImpl;
import com.springboot.mall.utils.JsonBean;
import com.springboot.mall.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService = new FeedbackServiceImpl();

    @ResponseBody
    @RequestMapping("/feedback/list")
    public JsonBean feedbackList(PageUtils pageUtils){

        JsonBean feedbackList = feedbackService.queryAllFeedback(pageUtils);
        return feedbackList;
    }

}
