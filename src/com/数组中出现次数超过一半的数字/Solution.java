package com.数组中出现次数超过一半的数字;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * 抢占阵地的原理
 *
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(MoreThanHalfNum_Solution(new int[]{1,2,3,4,6,4,3,4,4,5}));

    }

    static public int MoreThanHalfNum_Solution(int[] array) {

        if (array.length == 0) return 0;
        if (array.length == 1) return array[0];

        int pivot = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == pivot) {
                count++;
            } else {
                if (count == 0) {
                    pivot = array[i];
                    count++;
                } else {
                    count--;
                }
            }
        }


        count=0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == pivot) {
                count ++;
            }
        }

        if (count>=array.length/2+1){
            return pivot;
        }else{
            return 0;
        }
    }


}
