package com.lx.demo.controller.exercise;

/**
 * b
 *
 * @author LiuXue on 2020/3/15
 */
import java.util.Scanner;

public class b {

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
