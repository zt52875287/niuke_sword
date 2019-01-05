package com.不用加减乘除做加法;

import org.junit.Test;

public class Solution {
    @Test
    public void test() {
        System.out.println(Add(5,7));
    }

    public int Add(int num1, int num2) {

        int sum = num1;
        int enter = num2;

        while (enter != 0) {
            sum = num1 ^ num2;
            enter = (num1 & num2) << 1;
            num1 = sum;
            num2 = enter;
        }

        return num1;
    }
}
