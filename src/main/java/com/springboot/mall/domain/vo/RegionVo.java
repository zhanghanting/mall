package com.springboot.mall.domain.vo;

import java.util.List;

public class RegionVo {

    private Integer id;

    private Integer pid;

    private String name;

    private Byte type;

    private Integer code;

    private List<RegionVo> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<RegionVo> getChildren() {
        return children;
    }

    public void setChildren(List<RegionVo> children) {
        this.children = children;
    }
}
