package com.lx.demo.constant;

public class DemoClassConstant {

    //常用code常量
    public static final String SUCCCESS="S";
    public static final String FAILED="F";
    public static final String DEMO_EXCEPTION="E";

    public static final String SUCCCESS_CODE="0000";
    public static final String FAILED_CODE="1111";



    //常用响应msg
    public  static final String RETURN_MSG01="登录成功";
    public  static final String RETURN_MSG02="登录失败";
    public  static final String RETURN_MSG03="系统异常";

    /**
     * 通过获取的key选择对应的msg
     * @param key
     * @return
     */
    public  String  getSelect(String key){

        String msg="";
        switch(key){
            case "01":
                msg="第一个选择的msg";
                break;
            case "02":
                msg="第二个选择的msg";
                break;
            default:
                msg="默认的选择";
                break;
        }

        return msg;
    }


}
