package com.springboot.mall.mapper;

import com.springboot.mall.domain.Storage;
import com.springboot.mall.domain.StorageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StorageMapper {
    int insertStorage(@Param("storage") Storage storage);

<<<<<<< HEAD
    int deleteByExample(StorageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Storage record);

    int insertSelective(Storage record);

    List<Storage> selectByExample(StorageExample example);

    Storage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Storage record, @Param("example") StorageExample example);

    int updateByExample(@Param("record") Storage record, @Param("example") StorageExample example);

    int updateByPrimaryKeySelective(Storage record);

    int updateByPrimaryKey(Storage record);
=======
    Storage selectStorageByUrl(@Param("url") String url);
>>>>>>> 137c57c3173242ce170d83b2eed992c1acd9ee70
}