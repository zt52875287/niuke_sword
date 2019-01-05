package com.字符串的排列;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    @Test
    public void test() {
        String s = "abcd";
        ArrayList<String> per = Permutation(s);
        for (String s1 : per) {
            System.out.println(s1 + " - ");
        }

    }

    public ArrayList<String> Permutation(String str) {

        ArrayList<String> list = new ArrayList<>();
        if (str.length() == 0) return list;

        getPermutation(str.toCharArray(), 0, list);
        Collections.sort(list);
        return list;
    }

    private void getPermutation(char[] array, int start, ArrayList<String> list) {

        if (start == array.length) {
            String s = String.valueOf(array);
            if (!list.contains(s)) {
                list.add(s);
            }

        } else {

            for (int i = start; i < array.length; i++) {
                swap(start, i, array);

                getPermutation(array, start + 1, list);
                swap(start, i, array);

            }
        }
    }

    private void swap(int start, int i, char[] array) {
        char tmp = array[start];
        array[start] = array[i];
        array[i] = tmp;
    }
}