package com.ray.jxc.pojo;

import java.util.Date;

/**
 * @author ray
 * @create 2023-04-21 10:26
 */
public class Type {

    private String id;

    private String name;

    private String pId;

    private Date createTime;

    public Type() {
    }

    public Type(String id, String name, String pId, Date createTime) {
        this.id = id;
        this.name = name;
        this.pId = pId;
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pId='" + pId + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
