package com.数组中只出现一次的数字;

import com.tasks.FindLastLinkNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {

    @Test
    public void test() {
        int a[] = new int[]{1, 1, 3, 3, 5, 5, 2, 7, 7, 9, 8, 8};
        int b[] = new int[1];
        int c[] = new int[1];
        //笨办法,hashmap
//        FindNumsAppearOnce1(a,b,c);
        //高手: 异或
        FindNumsAppearOnce(a, b, c);
        //大神: 数组中有一个数字只出现了一次,其他都是2次,求这个数字
//        FindNumsAppearOnce3(a, b);
        //上帝: 数组中有一个数字只出现了一次,其他数字都是3次,求这个数字
//        FindNumsAppearOnce4(a, b);

        System.out.println(b[0] + "-" + c[0]);
    }

    /**
     * 数组中有一个数字只出现了一次,其他都是2次,求这个数字
     *
     * @param a
     * @param b
     */
    private void FindNumsAppearOnce3(int[] a, int[] b) {
        int tmp = 0;
        for (int i : a) {
            tmp ^= i;
        }
        b[0] = tmp;
    }

    /**
     * 数组中有一个数字只出现了一次,其他数字都是3次,求这个数字
     *
     * @param a
     * @param b
     */
    private void FindNumsAppearOnce4(int[] a, int[] b) {
        int bits[] = new int[32];
        for (int i : a) {
            for (int j = 0; j < 32; j++) {
                bits[j] += (i >> j) & 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] % 3 != 0) {
                result |= (1 << i);
            }
        }
        b[0] = result;
    }

    /**
     * 异或求解
     *
     * @param a
     * @param b
     * @param c
     */
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {

        int tmp = 0;
        for (int i = 0; i < array.length; i++) {
            tmp ^= array[i];
        }

        for (int i = 0; i < 32; i++) {
            if ((tmp >> i & 1) == 1) {
                tmp = i;
                break;
            }
        }

        num1[0] = 0;
        num2[0] = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] >> tmp & 1) == 0) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    /**
     * hashmap
     *
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce1(int[] array, int num1[], int num2[]) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        int flag = 1;

        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            if (entry.getValue() == 1) {
                if (flag == 1) {
                    num1[0] = entry.getKey();
                    flag++;
                } else if (flag == 2) {
                    num2[0] = entry.getKey();
                    break;
                }
            }
        }
    }
}
