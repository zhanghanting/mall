package com.springboot.mall.service.login.impl;

import com.springboot.mall.domain.vo.AdminVo;
import com.springboot.mall.domain.vo.ResponseVo;
import com.springboot.mall.mapper.AdminMapper;
import com.springboot.mall.mapper.PermissionMapper;
import com.springboot.mall.mapper.RoleMapper;
import com.springboot.mall.service.login.LoginService;
import com.springboot.mall.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService
{
    @Autowired
    AdminMapper adminMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    PermissionMapper permissionMapper;
    //
    @Override
    public JsonUtil login(ResponseVo responseVo,HashMap map)
    {
        //根据登录输入信息查询用户信息
        AdminVo adminVo = adminMapper.select(responseVo);
        if(adminVo != null)
        {
            ResponseVo responseVo1 = new ResponseVo();
            responseVo1.setUsername(adminVo.getUsername());
            responseVo1.setAvatar(adminVo.getAvatar());
            int[] roleIds = adminVo.getRoleIds();
            //放置用户角色名
            String[] roleNames = new String[roleIds.length];
            ArrayList<Object> permList = new ArrayList<>();
            for(int i = 0; i < roleIds.length;++i)
            {
                roleNames[i] = roleMapper.queryRoleNameById(roleIds[i]);
                List<String> permissions = permissionMapper.queryPermsById(roleIds[i]);
                for(String permission : permissions)
                {
                    permList.add(permission);
                }

            }
            String[] perms = new String[permList.size()];
            //权限赋值
            for(int i = 0;i < permList.size();++i)
                perms[i] = (String)permList.get(i);

            responseVo1.setRoles(roleNames);
            responseVo1.setPerms(perms);
            JsonUtil jsonUtil = new JsonUtil();
            jsonUtil.setErrno(0);
            jsonUtil.setErrmsg("成功");
            UUID uuid = UUID.randomUUID();
            map.put(uuid.toString(),responseVo1);
            jsonUtil.setData(uuid.toString());
            return jsonUtil;
        }
        else
        {
            return null;
        }

    }
}
