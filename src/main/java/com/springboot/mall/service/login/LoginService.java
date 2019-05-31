package com.springboot.mall.service.login;

import com.springboot.mall.domain.vo.ResponseVo;
import com.springboot.mall.utils.JsonUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public interface LoginService
{

    JsonUtil login(ResponseVo responseVo,HashMap map);
}
