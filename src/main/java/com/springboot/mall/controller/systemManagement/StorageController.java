package com.springboot.mall.controller.systemManagement;

import com.springboot.mall.domain.Storage;
import com.springboot.mall.service.systemManagement.StorageService;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class StorageController
{
    @Autowired
    StorageService storageService;
    @RequestMapping("/storage/list")
    @ResponseBody
    public JsonUtil getStorage(int page,int limit,String sort,String order,String key,String name)
    {
        MyPageHelper list = storageService.getList(page,limit,sort,order,key,name);
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setErrno(0);
        jsonUtil.setErrmsg("成功");
        jsonUtil.setData(list);
        return jsonUtil;
    }
    @ResponseBody
    @RequestMapping("/storage/create")
    public JsonUtil add(MultipartFile file,HttpServletRequest request)
    {
        JsonUtil jsonUtil = storageService.add(file,request);
        return  jsonUtil;
    }
    //更新对象的名称
    @ResponseBody
    @RequestMapping("/storage/update")
    public JsonUtil update(@RequestBody Storage storage)
    {
        JsonUtil jsonUtil = new JsonUtil();
        Storage storage1 = storageService.update(storage);
        jsonUtil.setErrno(0);
        jsonUtil.setErrmsg("成功");
        jsonUtil.setData(storage1);
        return jsonUtil;
    }
    //删除
    @ResponseBody
    @RequestMapping("/storage/delete")
    public JsonUtil delete(@RequestBody Storage storage)
    {
        JsonUtil jsonUtil = new JsonUtil();
        int delete = storageService.delete(storage);
        if(delete > 0)
        {
            jsonUtil.setErrmsg("成功");
            jsonUtil.setErrno(0);
        }
        return jsonUtil;
    }
}
