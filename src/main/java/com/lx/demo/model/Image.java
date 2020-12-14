package com.lx.demo.model;

import java.io.Serializable;

/**
 * 图片
 */
public class Image extends CommonHead implements Serializable {

    private static final long serialVersionUID = -6308477865306117105L;

    private String userNo;//用户no ---用户后续关联用户个人头像

    private String imagename;//图片名

    private String imageUrl;//图片url

    private String imageBase64;///图片base64

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }
}
