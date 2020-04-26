package com.lx.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        //sptringboot 项目启动类 run方法
        SpringApplication.run(DemoApplication.class, args);
        //定义初始化线程
        System.out.println("DemoApplication service run success  ");

    }

}
