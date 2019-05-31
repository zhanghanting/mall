package com.springboot.mall.service.systemManagement.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.mall.domain.Admin;
import com.springboot.mall.domain.vo.AdminVo;
import com.springboot.mall.mapper.AdminMapper;
import com.springboot.mall.service.systemManagement.AdminService;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.MyPageHelper;
import com.springboot.mall.utils.StringToIntArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService
{
    @Autowired
    AdminMapper adminMapper;
    /**
     *
     * @param page
     * @param limit
     * @param sort 表示按sort参数进行排序
     * @param order 表示升序还是降序
     * @return
     */
    @Override
    public MyPageHelper getList(int page,int limit,String sort,String order,String username)
    {
        PageHelper.startPage(page,limit);
        List<AdminVo> admins = getAdmins(sort,order,username);
        PageInfo<AdminVo> adminPageInfo = new PageInfo<>(admins);
        MyPageHelper pageHelper = new MyPageHelper();
        pageHelper.setItems(admins);
        pageHelper.setTotal(adminPageInfo.getTotal());
        return pageHelper;
    }

    @Override
    public List<AdminVo> getAdmins(String sort,String order,String username)
    {
        List<AdminVo> admins = adminMapper.getAdmins(sort,order,username);
        return admins;
    }

    @Override
    public JsonUtil add(MultipartFile file,HttpServletRequest request)
    {
        long l = System.currentTimeMillis();
        System.out.println(this.getClass().getClassLoader().getResource(""));
        String path = this.getClass().getClassLoader().getResource("").getPath() + "static/picture/";
        File dirFile = new File(path);
        if(!dirFile.exists()){
            dirFile.mkdirs();
        }
        //生成图片的存储路径

        File filePath = new File(path,l+"_"+file.getOriginalFilename());
        String requestURI = "http://" + "localhost:" + request.getLocalPort() + "/admin/picture/" + l +"_" + file.getOriginalFilename();
        Admin admin = new Admin();
        admin.setAvatar(requestURI);
        try
        {
            file.transferTo(filePath);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        return new JsonUtil(null,0,"OK");
    }

    @Override
    public int update(Admin admin)
    {
        int i = adminMapper.update(admin);
        return i;
    }

    @Override
    public int delete(Admin admin)
    {
        int i = adminMapper.deleteByPrimaryKey(admin.getId());
        return i;
    }
}
