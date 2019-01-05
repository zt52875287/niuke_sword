package com.斐波那契数列;

/**
 * @Author: zt52875287@gmail.com
 * @Date: 2018/12/22
 */
public class Solution {
    /**
     * f(n) = f(n-1) + f(n-2)
     * <p>
     * <p>
     * f(0)=0
     * f(1)=1
     * <p>
     * 0,1,1,2,3,5,8,13
     *
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = -1;
        }

        return getFib(n, tmp);
    }


    private int getFib(int n, int[] tmp) {

        if (n == 0) return 0;

        if (n == 1) return 1;

        if (n == 2) return 1;


        int fn1 = -1;
        if (tmp[n - 1] == -1) {
            tmp[n - 1] = getFib(n - 1, tmp);
        }
        fn1 = tmp[n - 1];

        int fn2 = -1;
        if (tmp[n - 2] == -1) {
            tmp[n - 2] = getFib(n - 2, tmp);
        }
        fn2 = tmp[n - 2];

        return fn1 + fn2;
    }

}
