package com.lx.demo.controller.exercise;

/**
 * 算法 输入
 * 题干
 * 一个含有n个数字的序列x1,x2,x3,…xn，可以进行以下操作：
 * 一次操作定义为对这个序列的每个数字进行以下两种改变之一：
 * 1.xi ÷ 2
 * 2.xi × 3
 * 每一次的操作中，必须保证至少有一个数字是第1种改变；并且经过每次操作后，每一个数字都必须是整数。
 * @author LiuXue on 2020/3/15
 */
import java.util.Scanner;

public class QueryChange {

        public static void main (String[] args) {
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
            int[] nums = new int[n];
            for(int i = 0;i < n; i++){
                nums[i] = scan.nextInt();
            }
            int sum = 0;
            boolean flag = true;
            while(flag){
                flag= false;
                for (int i = 0; i < n; i++) {
                    if (nums[i]%2 == 0) {
                        nums[i] = nums[i]/2;
                        sum++;
                        flag = true;
                    }
                }
            }
            System.out.println(sum);
        }

}
