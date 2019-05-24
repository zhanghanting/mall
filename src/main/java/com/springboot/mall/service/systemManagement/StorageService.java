package com.springboot.mall.service.systemManagement;
import com.springboot.mall.domain.Storage;
import com.springboot.mall.utils.MyPageHelper;

import java.util.List;

public interface StorageService
{
    //按格式返回分页数据
    MyPageHelper getList(int page,int limit,String sort,String order,String key,String name);
    //按排序参数sort,排序方式order返回所有的storage
    List<Storage> getStorage(String sort,String order,String key,String name);

    Storage update(Storage storage);

    int delete(Storage storage);
}
