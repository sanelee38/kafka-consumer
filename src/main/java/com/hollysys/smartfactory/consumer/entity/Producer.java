package com.hollysys.smartfactory.consumer.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Producer)实体类
 *
 * @author lizhi186545
 * @since 2021-09-28 13:54:15
 */
public class Producer implements Serializable {
    private static final long serialVersionUID = 503828049704625735L;

    private Integer id;

    private String name;

    private String item;

    private Date createTime;

    private Date updateTime;


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
        this.name = name;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}

