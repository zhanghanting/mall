package com.springboot.mall.controller;

import com.springboot.mall.service.AddressService;
import com.springboot.mall.service.impl.AddressServiceImpl;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@RequestMapping("/admin")
@Controller
public class AddressController {

    @Autowired
    AddressService addressService = new AddressServiceImpl();

    @ResponseBody
    @RequestMapping("/address/list")
    public JsonUtil addressList(PageUtils pageUtils){

        JsonUtil addressList = addressService.queryAllAddress(pageUtils);
        return addressList;
    }

}
