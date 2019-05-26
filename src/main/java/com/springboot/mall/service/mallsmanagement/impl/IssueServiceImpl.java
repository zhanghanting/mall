package com.springboot.mall.service.mallsmanagement.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.mall.domain.Issue;
import com.springboot.mall.mapper.IssueMapper;
import com.springboot.mall.service.mallsmanagement.IssueService;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.MallPageHelper;
import com.springboot.mall.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {
    @Autowired
    IssueMapper issueMapper;
    @Override
    public JsonUtil viewAllIssues(PageUtils pageUtils, String question) {
        if(question != null){
            question = "%" + question + "%";
        }
        PageHelper.startPage(pageUtils.getPage(),pageUtils.getLimit());
        List<Issue> issues = issueMapper.viewAllIssues(pageUtils.getSort(),pageUtils.getOrder(),question);
        PageInfo pageInfo = new PageInfo(issues);
        MallPageHelper mallPageHelper = new MallPageHelper();
        mallPageHelper.setItems(issues);
        mallPageHelper.setTotal(pageInfo.getTotal());
        return new JsonUtil(mallPageHelper,0,"成功");
    }

    @Override
    public JsonUtil insertIssue(Issue issue) {
        issueMapper.insertIssue(issue);
        return new JsonUtil(issue,0,"成功");
    }

    @Override
    public JsonUtil updateIssueById(Issue issue) {
        issueMapper.updateIssueById(issue);
        return new JsonUtil(issue,0,"成功");

    }

    @Override
    public JsonUtil deleteIssueById(Issue issue) {
        issueMapper.deleteIssueById(issue);
        return new JsonUtil(issue,0,"成功");
    }
}
