package com.springboot.mall.service.impl;

import com.springboot.mall.domain.Storage;
import com.springboot.mall.mapper.StorageMapper;
import com.springboot.mall.service.StorageService;
import com.springboot.mall.utils.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    StorageMapper storageMapper;

    @Override
    public JsonBean insertSrorage(MultipartFile file, HttpServletRequest request) throws IOException {

        long l = System.currentTimeMillis();
        String path = this.getClass().getClassLoader().getResource("").getPath() + "static/picture/";
        File dirFile = new File(path);
        if(!dirFile.exists()){
            dirFile.mkdirs();
        }
        File filePath = new File(path,l+"_"+file.getOriginalFilename());
        String requestURI = "http://" + request.getLocalAddr()+ ":" + request.getLocalPort() + "/admin/picture/" + l +"_" + file.getOriginalFilename();
        Storage storage = new Storage();
        storage.setKey(file.getOriginalFilename());
        storage.setSize((int) file.getSize());
        storage.setType(file.getContentType());
        storage.setName(file.getOriginalFilename());
        storage.setUrl(requestURI);
        storageMapper.insertStorage(storage);
        storage = storageMapper.selectStorageByUrl(requestURI);
        file.transferTo(filePath);
        return new JsonBean(storage,0,"OK");
    }
}
