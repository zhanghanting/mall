package com.springboot.mall.service.systemManagement;

import com.springboot.mall.domain.Admin;
import com.springboot.mall.domain.vo.AdminVo;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.MyPageHelper;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface AdminService
{
    //按格式返回分页数据
    MyPageHelper getList(int page,int limit,String sort,String order,String username);
    //按排序参数sort,排序方式order返回所有的admin
    List<AdminVo> getAdmins(String sort,String order,String username);

    JsonUtil add(MultipartFile file,HttpServletRequest request);

    int update(Admin admin);

    int delete(Admin admin);
}
