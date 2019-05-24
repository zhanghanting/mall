package com.springboot.mall.mapper;

import com.springboot.mall.domain.Admin;
import com.springboot.mall.domain.AdminExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    String find(@Param("id") int id);

    List<Admin> getAdmins(@Param("sort") String sort,@Param("order") String order);
}