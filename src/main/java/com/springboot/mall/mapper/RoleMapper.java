package com.springboot.mall.mapper;

import com.springboot.mall.domain.Role;
import com.springboot.mall.domain.RoleExample;
import com.springboot.mall.domain.vo.RoleVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> getRoles(@Param("sort") String sort,@Param("order") String order,@Param("name") String name);

    int add(@Param("role") Role role);

    int delete(@Param("role") Role role);
    int update(@Param("role") Role role);

    List<RoleVo> getRoleVo();

    String queryRoleNameById(@Param("roleId") int roleId);
}