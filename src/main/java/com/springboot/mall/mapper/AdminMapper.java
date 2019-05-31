package com.springboot.mall.mapper;

import com.springboot.mall.domain.Admin;
import com.springboot.mall.domain.AdminExample;
import com.springboot.mall.domain.vo.AdminVo;
import com.springboot.mall.domain.vo.ResponseVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    String find(@Param("id") int id);

    List<AdminVo> getAdmins(@Param("sort") String sort,@Param("order") String order,@Param("name") String name);
    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(@Param("id") Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    int update(@Param("admin") Admin admin);
    //查询管理员信息
    AdminVo select(@Param("responseVo") ResponseVo responseVo);
}