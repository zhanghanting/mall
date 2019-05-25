package com.springboot.mall.controller.mallsmanagement;

import com.springboot.mall.domain.Issue;
import com.springboot.mall.service.mallsmanagement.IssueService;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/issue")
public class IssueController {

    @Autowired
    IssueService issueService;

    @RequestMapping("/list")
    public JsonUtil list(PageUtils pageUtils,String question){
        return issueService.viewAllIssues(pageUtils,question);
    }
    @RequestMapping("/create")
    public JsonUtil create(@RequestBody Issue issue){
        return issueService.insertIssue(issue);
    }
    @RequestMapping("/update")
    public JsonUtil update(@RequestBody Issue issue){
        return issueService.updateIssueById(issue);
    }@RequestMapping("/delete")
    public JsonUtil delete(@RequestBody Issue issue){
        return issueService.deleteIssueById(issue);
    }
}
