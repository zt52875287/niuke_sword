package com.求1到n的和;

import org.junit.Test;

public class Solution {

    @Test
    public void test(){
        System.out.println(Sum_Solution(1000));
    }

    public int Sum_Solution(int n) {

        int sum=n;

        boolean flag = n>0 && (sum+=Sum_Solution(--n))>0;

        return sum;
    }
}
