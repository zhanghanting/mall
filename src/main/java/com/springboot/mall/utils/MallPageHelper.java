package com.springboot.mall.utils;

import java.util.List;

public class MallPageHelper {
    private List items;
    private long total;

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "MallPageHelper{" +
                "items=" + items +
                ", total=" + total +
                '}';
    }
}
