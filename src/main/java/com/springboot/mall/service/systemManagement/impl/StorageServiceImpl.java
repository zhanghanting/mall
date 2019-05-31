package com.springboot.mall.service.systemManagement.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.mall.domain.Storage;
import com.springboot.mall.mapper.StorageMapper;
import com.springboot.mall.service.systemManagement.StorageService;
import com.springboot.mall.utils.JsonUtil;
import com.springboot.mall.utils.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
@Service
public class StorageServiceImpl implements StorageService
{
    @Autowired
    StorageMapper storageMapper;
    @Override
    public MyPageHelper getList(int page,int limit,String sort,String order,String key,String name)
    {
        PageHelper.startPage(page,limit);
        List<Storage> storage = getStorage(sort,order,key,name);
        PageInfo<Storage> logPageInfo = new PageInfo<>(storage);
        MyPageHelper pageHelper = new MyPageHelper();
        pageHelper.setItems(storage);
        pageHelper.setTotal(logPageInfo.getTotal());
        return pageHelper;
    }

    @Override
    public List<Storage> getStorage(String sort,String order,String key,String name)
    {
        List<Storage> storage =storageMapper.getStorage(sort,order,key,name);
        return storage;
    }
    //更新
    @Override
    public Storage update(Storage storage)
    {
        int update = storageMapper.update(storage);
        if(update > 0)
        {
            return storage;
        }
        else
            return null;
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
        Storage storage = new Storage();
        storage.setKey(file.getOriginalFilename());
        storage.setSize((int) file.getSize());
        storage.setType(file.getContentType());
        storage.setName(file.getOriginalFilename());
        storage.setUrl(requestURI);
        storageMapper.insertStorage(storage);
        storage = storageMapper.selectStorageByUrl(requestURI);
        try
        {
            file.transferTo(filePath);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        return new JsonUtil(storage,0,"OK");
    }

    @Override
    public int delete(Storage storage)
    {
        int i = storageMapper.deleteByPrimaryKey(storage.getId());
        return i;
    }
}
