package com.lx.demo.constant;

public class DemoClassConstant {

    //常用code常量
    private String DEMO_SUCCCESS="S";
    private String DEMO_FAILED="F";
    private String DEMO_EXCEPTION="E";


    //常用响应msg
    private  String RETURN_MSG01="登录成功";
    private  String RETURN_MSG02="登录失败";
    private  String RETURN_MSG03="系统异常";

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
