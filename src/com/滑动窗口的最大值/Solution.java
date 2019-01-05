package com.滑动窗口的最大值;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @Author: zt52875287@gmail.com
 * @Date: 2018/12/13
 */
public class Solution {

    @Test
    public void test(){
        int []a = new int[]{10,14,12,11};
        System.out.println(maxInWindows(a,5));
    }

    public ArrayList<Integer> maxInWindows(int[] num, int size) {

        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> queue = new ArrayList<>();

        if (size==0|| num.length<size) return result;

        int max = num[0];
        int maxCurse = 0;

        for (int i = 0; i < num.length ; i++) {

            if (i <= size - 1) {
                queue.add(num[i]);
                if (num[i] > max) {
                    max = num[i];
                    maxCurse = i;
                }
                if (i==size-1) {
                    result.add(max);
                }
                continue;
            }


            queue.remove(0);
            queue.add(num[i]);

            if (num[i] > max) {
                max = num[i];
                maxCurse = i;
            } else if (i - maxCurse >= size) {
                max = num[i];
                maxCurse = i;
                for (int j = size-1; j >=0; j--) {
                    if (max < queue.get(j)) {
                        max = queue.get(j);
                        maxCurse = j;
                    }
                }
            }
            result.add(max);
        }

        if (size > num.length) {
            result.add(max);
        }

        return result;

    }
}
