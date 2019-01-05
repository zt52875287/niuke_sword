package com.第一个只出现一次的字符;


import org.junit.Test;

import java.util.ArrayList;

public class Solution {
    @Test
    public void test(){
        System.out.println('A'+0);
        System.out.println('Z'+0);
        System.out.println('a'+0);
        System.out.println('z'+0);
        String s = "NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp";
        System.out.println((FirstNotRepeatingChar(s)));

    }


    public int FirstNotRepeatingChar(String str) {

        int[] bucket = new int[60];

        for (int i = 0; i < str.length(); i++) {
            bucket [ str.charAt(i)-65 ]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (bucket [ str.charAt(i)-65 ]==1){
                return i;
            }
        }

        return -1;
    }
}
