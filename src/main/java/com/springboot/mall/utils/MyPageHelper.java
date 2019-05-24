package com.springboot.mall.utils;

import java.util.List;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/23 20:59
 */

public class MyPageHelper<T> {
    private long total;
    private List<T> items;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}