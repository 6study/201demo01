package com.lx.demo.constant;

public enum DemoClassEnums {

    DEMO_01_EUM("01","第一个枚举","这是第一个例子使用的枚举"),
    DEMO_02_EUM("02","第二个枚举","这是第二个例子使用的枚举");


    private String code;
    private String msg;
    private String description;

    DemoClassEnums(String code, String msg, String description) {
        this.code = code;
        this.msg = msg;
        this.description = description;
    }

    /**
     * 通过code获取对应枚举值的msg
     * @param code
     * @return
     */
    public String getDemoClassEnumsMsg(String  code){
        DemoClassEnums demoClassEnums01=null;
        for(DemoClassEnums demoClassEnums02:values()){
            if(code.equals(demoClassEnums02.code)){
                demoClassEnums01=demoClassEnums02;
            }
        }
        return demoClassEnums01.msg;
    }
}
