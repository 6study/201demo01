package com.lx.demo.model;

import java.io.Serializable;

/**
 * 用户明细
 */
public class UserDetail extends CommonHead implements Serializable  {

    private static final long serialVersionUID = -2506886048188381095L;

    private String address;//地址

    private String qq;//qq邮箱

    private String province;//省份

    private String desCription;//描述

    private  String userNo;//用户账户

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDesCription() {
        return desCription;
    }

    public void setDesCription(String desCription) {
        this.desCription = desCription;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }
}
