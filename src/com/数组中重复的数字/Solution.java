package com.数组中重复的数字;

import org.junit.Test;



public class Solution {
    @Test
    public void test() {
        int[] a;
        duplicate(new int[0], 0, new int[1]);
    }

    public boolean duplicate(int numbers[], int length, int[] duplication) {

        boolean[] k = new boolean[length];
        for (int i = 0; i < length; i++) {

            if (k[numbers[i]] == true) {
                duplication[0] = numbers[i];
                return true;
            }

            k[numbers[i]] = true;
        }

        return false;
    }
}
