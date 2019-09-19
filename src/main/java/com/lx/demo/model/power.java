package com.lx.demo.model;

/**
 * 权限
 */
public class power {

    private String userNo;//用户no

    private String pageNo;//pageno

    private Boolean isRead;//是否显示

    private Boolean isWrite;//是否可更改

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    public Boolean getWrite() {
        return isWrite;
    }

    public void setWrite(Boolean write) {
        isWrite = write;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }
}
