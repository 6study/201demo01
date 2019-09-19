package com.lx.demo.model;

import java.io.Serializable;

/**
 * 用户
 */
public class User  implements Serializable  {

    /**
     * 唯一性id
     */
    private static final long serialVersionUID = -2098558948040661869L;

    private String userName;//用户名

    private String password;//密码

    private String sex;//性别

    private String userNo;//用户no

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

}
