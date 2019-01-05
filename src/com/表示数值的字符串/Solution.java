package com.表示数值的字符串;

/**
 * @Author: zt52875287@gmail.com
 * @Date: 2018/12/13
 */
public class Solution {
    public boolean isNumeric(char[] str) {
        try{
            Double.parseDouble(new String(str));

        }catch(Exception e){
            return false;
        }
        return true;
    }
}
