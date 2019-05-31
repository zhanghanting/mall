package com.springboot.mall.service.mallsmanagement;

import com.springboot.mall.domain.Keyword;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.PageUtils;

import java.util.List;

public interface KeywordService {
    JsonUtil viewAllKeywords(PageUtils pageUtils, Keyword keyword);

    JsonUtil insertKeyword(Keyword keyword);

    JsonUtil deleteKeywordById(Keyword keyword);

    JsonUtil updateKeywordById(Keyword keyword);
}
