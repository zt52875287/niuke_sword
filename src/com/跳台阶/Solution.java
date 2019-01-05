package com.跳台阶;

/**
 * @Author: zt52875287@gmail.com
 * @Date: 2018/12/21
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Solution {
    /**
     * 最后一步有两种跳法1或2，那么总次数就是：
     * f(n) = f(n-1) + f(n-2)
     * f(1) = 1
     * f(2) = 2
     *
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }
}
