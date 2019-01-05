package com.把字符串转换成整数;

import org.junit.Test;

/**
 * @Author: zt52875287@gmail.com
 * @Date: 2018/11/29
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(StrToInt("+12345"));
        System.out.println(StrToInt("0+2345"));
        System.out.println(StrToInt("+12340"));
        System.out.println(StrToInt("000000"));
        System.out.println(StrToInt("1g323"));
        System.out.println(StrToInt("1a33"));
        System.out.println('a'+0);
    }

    public int StrToInt(String str) {

        char[] arr = str.toCharArray();

        int result = 0;
        int flag =1;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] <= 57 && arr[i] >= 48) {
                result = result + (int) Math.pow(10, arr.length - 1-i) * (arr[i] - 48);
            }else if(i==0 && arr[i]==43){
                continue;
            }else if(i==0 && arr[i]==45){
                flag=-1;
                continue;
            }else{
                return 0;
            }
        }
        return result*flag;

    }
}
