package com.左旋转字符串;

import org.junit.Test;

public class Solution {
    @Test
    public void test() {
        System.out.println(LeftRotateString("abcdefghi", 2));
    }

    public String LeftRotateString(String str, int n) {
        if (str.length()==0) return str;
        char[] chars = str.toCharArray();
        str = str.copyValueOf(chars, n , chars.length - n) +
                str.copyValueOf(chars, 0, n);
        return str;
    }
}
