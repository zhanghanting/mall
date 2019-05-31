package com.springboot.mall.service.mallsmanagement;


import com.springboot.mall.domain.Issue;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.PageUtils;

public interface IssueService {

    JsonUtil viewAllIssues(PageUtils pageUtils, String question);

    JsonUtil insertIssue(Issue issue);

    JsonUtil updateIssueById(Issue issue);

    JsonUtil deleteIssueById(Issue issue);
}
