package com.和为S的连续正数序列;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @Author: zt52875287@gmail.com
 * @Date: 2018/11/28
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(FindContinuousSequence(4));

    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = sum/2+1; i >1; i--) {
            if (i %2 == 1 && sum % i == 0 && sum / i - (i - 1) / 2 > 0 && sum / i - (i - 1) / 2 <= sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int k = 0, j = sum / i - (i - 1) / 2; k < i; k++, j++) {
                    list.add(j);
                }
                result.add(list);
            } else if (sum % i*2 == i  && sum / i - i / 2 + 1>0 && sum / i - i / 2 + 1<sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int k = 0, j = sum / i - i / 2 + 1; k < i; j++, k++) {
                    list.add(j);
                }
                result.add(list);
            }
        }

        return result;
    }
}
