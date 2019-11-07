package com.lx.demo.portocol;

import java.io.Serializable;

public class ResHead implements Serializable {
    private static final long serialVersionUID = -7862103348999159062L;

    /**
     * 相应状态
     */
    private String resStatus;

    /**
     * 响应状态码
     */
    private String resCode;

    /**
     * 进程状态
     */
    private String resProcessStatus;

    public String getResStatus() {
        return resStatus;
    }

    public void setResStatus(String resStatus) {
        this.resStatus = resStatus;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResProcessStatus() {
        return resProcessStatus;
    }

    public void setResProcessStatus(String resProcessStatus) {
        this.resProcessStatus = resProcessStatus;
    }
}
