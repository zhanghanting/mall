package com.springboot.mall.mapper;

import com.springboot.mall.domain.Keyword;
import com.springboot.mall.domain.KeywordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KeywordMapper {
    long countByExample(KeywordExample example);

    int deleteByExample(KeywordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Keyword record);

    int insertSelective(Keyword record);

    List<Keyword> selectByExample(KeywordExample example);

    Keyword selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Keyword record, @Param("example") KeywordExample example);

    int updateByExample(@Param("record") Keyword record, @Param("example") KeywordExample example);

    int updateByPrimaryKeySelective(Keyword record);

    int updateByPrimaryKey(Keyword record);

    List<Keyword> viewAllKeywords(@Param("sort") String sort,@Param("order") String order,@Param("keyword")  Keyword keyword);

    void insertKeyword(@Param("keyword") Keyword keyword);

    void deleteKeywordById(@Param("keyword")Keyword keyword);

    void updateKeywordById(@Param("keyword")Keyword keyword);
}