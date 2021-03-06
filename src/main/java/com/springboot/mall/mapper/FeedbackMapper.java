package com.springboot.mall.mapper;

import com.springboot.mall.domain.Feedback;
import com.springboot.mall.domain.FeedbackExample;
import com.springboot.mall.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FeedbackMapper {
    long countByExample(FeedbackExample example);

    int deleteByExample(FeedbackExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Feedback record);

    int insertSelective(Feedback record);

    List<Feedback> selectByExample(FeedbackExample example);

    Feedback selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Feedback record, @Param("example") FeedbackExample example);

    int updateByExample(@Param("record") Feedback record, @Param("example") FeedbackExample example);

    int updateByPrimaryKeySelective(Feedback record);

    int updateByPrimaryKey(Feedback record);

    List<Feedback> queryAllFeedback(PageUtils pageUtils);
}