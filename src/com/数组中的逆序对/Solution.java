package com.数组中的逆序对;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: zt52875287@gmail.com
 * @Date: 2018/11/29
 */
public class Solution {
    @Test
    public void test() {
//        int[] a = new int[]{2, 5, 3, 8, 10, 6, 1, 4, 9};
        int[] a = new int[]{4, 1, 4, 3};
        int r = mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
        System.out.println(r);
    }

    public int InversePairs(int[] array) {
        return mergeSort(array, 0, array.length - 1);
    }


    private int mergeSort(int[] a, int head, int tail) {
        int right = 0;
        int left = 0;
        int count = 0;

        if (head < tail) {

            int mid = (head + tail) / 2;
            left = mergeSort(a, head, mid)% 1000000007;
            right = mergeSort(a, mid + 1, tail)% 1000000007;
            count = merge(a, head, mid, tail)% 1000000007;

        }
        return (left + right + count)% 1000000007;
    }

    private int merge(int[] a, int head, int mid, int tail) {
        int[] tmp = new int[tail - head + 1];
        int p1 = mid;
        int p2 = tail;
        int count = 0;
        int curse = tmp.length - 1;
        while (p1 >= head && p2 >= mid + 1) {
            if (a[p1] > a[p2]) {
                tmp[curse--] = a[p1--];
                count = count + p2 - mid;
                count = count >= 1000000007 ? count % 1000000007 : count;
            } else {
                tmp[curse--] = a[p2--];
            }
        }

        while (p1 >= head) {
            tmp[curse--] = a[p1--];
        }
        while (p2 >= mid + 1) {
            tmp[curse--] = a[p2--];
        }

        for (int i = head; i <= tail; i++) {
            a[i] = tmp[i - head];
        }

        return  count% 1000000007 ;
    }


}
