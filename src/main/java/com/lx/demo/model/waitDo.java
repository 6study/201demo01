package com.lx.demo.model;

/**
 * 代待办
 */
public class waitDo {

    private String item; //主题

    private String description;//描述

    private String date;//日期

    private String type;//类型

    private  Boolean isImportanmnt;//重点标记

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getImportanmnt() {
        return isImportanmnt;
    }

    public void setImportanmnt(Boolean importanmnt) {
        isImportanmnt = importanmnt;
    }
}
