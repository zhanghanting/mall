package com.springboot.mall.controller;


import com.springboot.mall.domain.Storage;
import com.springboot.mall.service.StorageService;
import com.springboot.mall.utils.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URL;

@RestController
@RequestMapping("/storage")
public class StorageController {



    @Autowired
    StorageService storageService;

    @RequestMapping("/create")
    public JsonBean create(MultipartFile file, HttpServletRequest request) throws IOException {
        return storageService.insertSrorage(file,request);


        /*String path = this.getClass().getClassLoader().getResource("").getPath() + "template/picture/";
        File dirFile = new File(path);
        if(!dirFile.exists()){
            dirFile.mkdirs();
        }
        File filePath = new File(path,file.getOriginalFilename());
        String requestURI = "http://" + request.getLocalAddr() + "/picture/" + file.getOriginalFilename();
        Storage storage = new Storage();
        storage.setKey(file.getOriginalFilename());
        storage.setSize((int) file.getSize());
        storage.setType(file.getContentType());
        System.out.println(file.getName());
        storage.setName(file.getOriginalFilename());
        storage.setUrl(requestURI);
        JsonBean jsonBean = storageService.insertSrorage(storage);
        file.transferTo(filePath);*/


    }
}
