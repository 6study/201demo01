package com.lx.demo.controller.exercise;

public class Sub extends Base {
    private static String baseName = "sub";

    public void callName() {
        System.out.println(baseName);
    }

    public static void main(String[] args) {
        Base b = new Sub();
    }
}