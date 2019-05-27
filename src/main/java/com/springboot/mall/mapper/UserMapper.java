package com.springboot.mall.mapper;

import com.springboot.mall.domain.User;
import com.springboot.mall.domain.UserExample;
import com.springboot.mall.utils.UserPageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

<<<<<<< HEAD
    List<User> queryAllUser(UserPageUtils userPageUtils);

=======
    User viewUserById(@Param("id") Integer id);
>>>>>>> 6b02638d3197da7aaddde92734d0bbf6aecc5496
}