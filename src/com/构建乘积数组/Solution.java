package com.构建乘积数组;

/**
 * @Author: zt52875287@gmail.com
 * @Date: 2018/12/5
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    @Test
    public void test(){
        System.out.println(Arrays.toString(multiply(new int[]{1, 2, 3, 4, 5})));
    }
    public int[] multiply(int[] A) {

        int[] b = new int[A.length];

        b[0] = 1;

        for (int i = 1; i < A.length; i++) {
            b[i] = b[i - 1] * A[i - 1];
        }

        int tmp = 1;

        for (int i = A.length - 1; i >= 1; i--) {
            tmp *= A[i];
            b[i - 1] *= tmp;
        }
        return b;

    }
}
