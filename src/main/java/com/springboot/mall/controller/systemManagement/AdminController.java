package com.springboot.mall.controller.systemManagement;

import com.springboot.mall.domain.Admin;
import com.springboot.mall.domain.vo.AdminVo;
import com.springboot.mall.domain.vo.RoleVo;
import com.springboot.mall.service.systemManagement.AdminService;
import com.springboot.mall.service.systemManagement.RoleService;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController
{
    @Autowired
    AdminService adminService;
    @Autowired
    RoleService roleService;
    @ResponseBody
    @RequestMapping("/admin/list")
    public JsonUtil getAdmin(int page,int limit,String sort,String order,String username)
    {
        MyPageHelper list = adminService.getList(page,limit,sort,order,username);
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setData(list);
        jsonUtil.setErrmsg("成功");
        jsonUtil.setErrno(0);
        return jsonUtil;
    }
    @ResponseBody
    @RequestMapping("/role/options")
    public JsonUtil getRoles()
    {
        List<RoleVo> list = roleService.getRoleVo();
        JsonUtil jsonUtil = new JsonUtil();
        if(list != null)
        {
            jsonUtil.setErrno(0);
            jsonUtil.setErrmsg("成功");
            jsonUtil.setData(list);
        }
        return jsonUtil;
    }
    @ResponseBody
    @RequestMapping("/admin/create")
    public JsonUtil add(MultipartFile file,HttpServletRequest request)
    {
        JsonUtil jsonUtil = adminService.add(file,request);
        return  jsonUtil;
    }
    @ResponseBody
    @RequestMapping("/admin/update")
    public JsonUtil update(@RequestBody Admin admin)
    {
        JsonUtil jsonUtil = new JsonUtil();
        int delete = adminService.update(admin);
        if(delete > 0)
        {
            jsonUtil.setErrmsg("成功");
            jsonUtil.setErrno(0);
        }
        return jsonUtil;
    }
    @ResponseBody
    @RequestMapping("admin/delete")
    public JsonUtil delete(@RequestBody Admin admin)
    {
        JsonUtil jsonUtil = new JsonUtil();
        int delete = adminService.delete(admin);
        if(delete > 0)
        {
            jsonUtil.setErrmsg("成功");
            jsonUtil.setErrno(0);
        }
        return jsonUtil;

    }


}
