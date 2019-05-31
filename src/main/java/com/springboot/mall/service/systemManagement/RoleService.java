package com.springboot.mall.service.systemManagement;

import com.springboot.mall.domain.Log;
import com.springboot.mall.domain.Role;
import com.springboot.mall.domain.vo.RoleVo;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.MyPageHelper;

import java.util.List;

public interface RoleService
{
    MyPageHelper getList(int page,int limit,String sort,String order,String name);
    //按排序参数sort,排序方式order返回所有的log
    List<Role> getRoles(String sort,String order,String name);

    Role add(Role role);

    JsonUtil delete(Role role);

    JsonUtil update(Role role);

    List<RoleVo> getRoleVo();
}
