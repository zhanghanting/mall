package com.springboot.mall.domain.vo;

import java.util.Date;
import java.util.List;

public class CategoryVo {
    private Integer id;

    private String name;

    private String keywords;

    private String desc;


    private String iconUrl;

    private String picUrl;

    private String level;


    private List<CategoryLevel2> childen;

    public List<CategoryLevel2> getChilden() {
        return childen;
    }

    public void setChilden(List<CategoryLevel2> childen) {
        this.childen = childen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }


    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl == null ? null : iconUrl.trim();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }


}