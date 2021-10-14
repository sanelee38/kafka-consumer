package com.hollysys.smartfactory.consumer.entity;

import java.io.Serializable;

/**
 * (Consumer)实体类
 *
 * @author lizhi186545
 * @since 2021-09-28 11:22:01
 */
public class Consumer implements Serializable {
    private static final long serialVersionUID = 179771906220753248L;

    private Integer id;

    private String name;

    private String item;


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

}

