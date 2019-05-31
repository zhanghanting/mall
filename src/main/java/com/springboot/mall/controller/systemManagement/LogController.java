package com.springboot.mall.controller.systemManagement;

import com.springboot.mall.service.systemManagement.LogService;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class LogController
{
    @Autowired
    LogService logService;
    @RequestMapping("/log/list")
    @ResponseBody
    public JsonUtil getLogs(int page,int limit,String sort,String order,String name)
    {
        MyPageHelper list = logService.getList(page,limit,sort,order,name);
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setErrno(0);
        jsonUtil.setErrmsg("成功");
        jsonUtil.setData(list);
        return jsonUtil;
    }
}
