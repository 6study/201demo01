package com.lx.demo.controller.exercise;

/**
 * 方法使用 有效顺序
 */
class   StaticStuff
 { 
                  static  int  x=10;
                  static  { x+=5;}
                  public  static  void  main(String  args[ ])
                  {
                       System.out.println("x=" + x);
                  }
                  static  { x/=3;}
   }