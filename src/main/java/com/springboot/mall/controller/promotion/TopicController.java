package com.springboot.mall.controller.promotion;

import com.springboot.mall.domain.Topic;
import com.springboot.mall.service.promotion.TopicService;
import com.springboot.mall.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/26 10:45
 */

@Controller
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    TopicService topicService;


    //获取列表 (title、subtitle为空时返回全部列表)
    @RequestMapping("/list")
    @ResponseBody
    public Object list(String title, String subtitle, Integer page, Integer limit, String sort, String order) {
        List<Topic> topicList = topicService.querySelective(title, subtitle, page, limit, sort, order);
        return ResponseUtil.okList(topicList);
    }


    //验证是否合法
    private Object validate(Topic topic) {
        String title = topic.getTitle();
        if (StringUtils.isEmpty(title)) {
            return ResponseUtil.badArgument();
        }
        String content = topic.getContent();
        if (StringUtils.isEmpty(content)) {
            return ResponseUtil.badArgument();
        }
        BigDecimal price = topic.getPrice();
        if (price == null) {
            return ResponseUtil.badArgument();
        }
        return null;
    }


    //添加
    @RequestMapping("/create")
    @ResponseBody
    public Object create(@RequestBody Topic topic) {
        Object error = validate(topic);
        if (error != null) {
            return error;
        }
        topicService.add(topic);
        return ResponseUtil.ok(topic);
    }




    //详情
    @RequestMapping("/read")
    @ResponseBody
    public Object read(@NotNull Integer id) {
        Topic topic = topicService.findById(id);
        return ResponseUtil.ok(topic);
    }


    //编辑
    @RequestMapping("/update")
    @ResponseBody
    public Object update(@RequestBody Topic topic) {
        Object error = validate(topic);
        if (error != null) {
            return error;
        }
        if (topicService.updateById(topic) == 0) {
            return ResponseUtil.updatedDataFailed();
        }
        return ResponseUtil.ok(topic);
    }


    //删除
    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(@RequestBody Topic topic) {
        topicService.deleteById(topic.getId());
        return ResponseUtil.ok();
    }
}
