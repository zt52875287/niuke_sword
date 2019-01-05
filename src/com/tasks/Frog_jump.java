package com.tasks;

/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法
（先后次序不同算不同的结果）。
*/

/*
递归
非递归
*/

import java.util.jar.JarEntry;

public class Frog_jump {


    public static void main(String[] args) {

        Frog_jump frog_jump = new Frog_jump();

        long t = System.currentTimeMillis();
        System.out.println(frog_jump.JumpFloor_1(40));
        System.out.println(System.currentTimeMillis() - t);

        t = System.currentTimeMillis();
        System.out.println(frog_jump.JumpFloor_2(40));
        System.out.println(System.currentTimeMillis() - t);

    }


    public int JumpFloor_1(int target) {


        if (target == 1) return 1;
        if (target == 2) return 2;

        int target_1 = 2;
        int target_2 = 1;

        int tmp = 0;

        for (int i = 3; i <= target; i++) {
            tmp = target_1;
            target_1 = target_1+ target_2;
            target_2 = tmp;
        }

        return target_1;
    }


    public int JumpFloor_2(int target) {

        if (target == 1) return 1;
        if (target == 2) return 2;

        return JumpFloor_2(target - 1) + JumpFloor_2(target-2);
    }
}
