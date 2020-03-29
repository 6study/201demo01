package com.lx.demo.controller.exercise;

/**
 * 枚举
 */
public class Example{

    public enum Color{Red,Green,Blue};
    public void foo(){
            for(Color c:Color.values())
            System.out.println(c);

    }
}