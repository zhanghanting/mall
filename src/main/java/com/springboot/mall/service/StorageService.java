package com.springboot.mall.service;

import com.springboot.mall.domain.Storage;
import com.springboot.mall.utils.JsonUtil;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface StorageService {
    JsonUtil insertSrorage(MultipartFile file, HttpServletRequest request) throws IOException;
}
