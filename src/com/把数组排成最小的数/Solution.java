package com.把数组排成最小的数;

import org.junit.Test;

import java.util.Arrays;


public class Solution {
    @Test
    public void test() {
        System.out.println(PrintMinNumber(new int[]{1111, 222222, 3333, 55555, 4}));
    }

    public String PrintMinNumber(int[] numbers) {

        Integer[] itg = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            itg[i] = numbers[i];
        }

        Arrays.sort(itg, (o1, o2) -> {
            String s1 = o1 + "" + o2;
            String s2 = o2 + "" + o1;
            return s1.compareTo(s2);
        });

        StringBuffer sb = new StringBuffer();
        for (Integer i : itg) {
            sb = sb.append(i);
        }
        return sb.toString();
    }
}