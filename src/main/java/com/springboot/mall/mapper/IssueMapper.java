package com.springboot.mall.mapper;

import com.springboot.mall.domain.Issue;
import com.springboot.mall.domain.IssueExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IssueMapper {
    long countByExample(IssueExample example);

    int deleteByExample(IssueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Issue record);

    int insertSelective(Issue record);

    List<Issue> selectByExample(IssueExample example);

    Issue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Issue record, @Param("example") IssueExample example);

    int updateByExample(@Param("record") Issue record, @Param("example") IssueExample example);

    int updateByPrimaryKeySelective(Issue record);

    int updateByPrimaryKey(Issue record);

    List<Issue> viewAllIssues(@Param("sort") String sort,
                              @Param("order")String order,
                              @Param("question") String question);

    void insertIssue(@Param("issue") Issue issue);

    void updateIssueById(@Param("issue")Issue issue);

    void deleteIssueById(@Param("issue")Issue issue);
}