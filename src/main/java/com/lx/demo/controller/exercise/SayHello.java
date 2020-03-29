package com.lx.demo.controller.exercise;

/**
 * 内部函数 与 外部方法
 */
public class SayHello {
    
    public static void say(String name){
        name = name + "say hello!";
    }
    public static void main(String[] args) {
        String name = "zhangsan";
        say(name);
        System.out.println(name);
    }
}