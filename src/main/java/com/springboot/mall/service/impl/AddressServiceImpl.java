package com.springboot.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.mall.domain.Address;
import com.springboot.mall.mapper.AddressMapper;
import com.springboot.mall.service.AddressService;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.MallPageHelper;
import com.springboot.mall.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressMapper addressMapper;

    @Override
    public JsonUtil queryAllAddress(PageUtils pageUtils) {
        PageHelper.startPage(pageUtils.getPage(),pageUtils.getLimit());
        JsonUtil addressJsonBean = new JsonUtil();
        MallPageHelper addressData = new MallPageHelper();
        List<Address> addresses = addressMapper.queryAllAddress(pageUtils);
        PageInfo<Address> pageInfo = new PageInfo<>(addresses);
        addressData.setItems(addresses);
        addressData.setTotal(pageInfo.getTotal());
        addressJsonBean.setData(addressData);
        addressJsonBean.setErrno(0);
        addressJsonBean.setErrmsg("成功");
        return addressJsonBean;
    }
}
