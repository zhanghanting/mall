package com.springboot.mall.controller.systemManagement;

import com.springboot.mall.domain.vo.AdminVo;
import com.springboot.mall.service.systemManagement.AdminService;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminController
{
    @Autowired
    AdminService adminService;
    @ResponseBody
    @RequestMapping("/admin/list")
    public JsonUtil getAdmin(int page,int limit,String sort,String order)
    {
        MyPageHelper list = adminService.getList(page,limit,sort,order);
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setData(list);
        jsonUtil.setErrmsg("成功");
        jsonUtil.setErrno(0);
        return jsonUtil;
    }
}
