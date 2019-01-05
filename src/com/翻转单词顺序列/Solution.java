package com.翻转单词顺序列;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;

public class Solution {
    @Test
    public void test() {
        System.out.println(ReverseSentence(" i am a student."));
    }

    public String ReverseSentence(String str) {
        String[] split = str.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = split.length - 1; i >= 0; i--) {
            stringBuffer.append(split[i] + " ");
        }
        return stringBuffer.toString().substring(0, stringBuffer.length() - 1);
    }
}
