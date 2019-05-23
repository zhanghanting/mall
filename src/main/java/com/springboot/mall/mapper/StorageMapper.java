package com.springboot.mall.mapper;

import com.springboot.mall.domain.Storage;
import com.springboot.mall.domain.StorageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StorageMapper {
    int insertStorage(@Param("storage") Storage storage);

    Storage selectStorageByUrl(@Param("url") String url);
}