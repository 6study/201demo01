package com.lx.demo.controller.exercise;

public class Base {
    private String baseName = "base";
    public Base(){
        callName();
    }
    public void callName(){
        System.out.println(baseName);
    }
}