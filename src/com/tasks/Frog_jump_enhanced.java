package com.tasks;

import java.util.concurrent.ForkJoinPool;
/*
题目描述
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

我的方法复杂度较高，时间n^2 空间n


简单方法：
a[n]=    a[n-1]+a[n-2]+......+a[1];..........................①
a[n-1]=         a[n-2]+......+a[1];..........................②
两式相减可知：a[n]=2*a[n-1];

 */

public class Frog_jump_enhanced {


    public static void main(String[] args) {


        int n = 10;
        System.out.println("---"+JumpFloorII(n));
        System.out.println("---"+JumpFloorII_2(n));

    }

    public static int JumpFloorII_2(int target) {
        return (int) Math.pow(2, target - 1);
    }


    public static int JumpFloorII(int target) {

        if (target==1) return 1;
        if (target==2) return 2;

        int[] base = new int[target];
        base[0] =1;
        base[1] =2;

        for (int i = 2; i < target; i++) {
            int pre = 0;
            for (int j = 0; j < i; j++) {
                pre = pre + base[j];
            }
            base[i] = pre +1;
        }


        for (int i = 0; i < target; i++) {
            System.out.println(base[i]);
        }

        return base[base.length-1];
    }



}
