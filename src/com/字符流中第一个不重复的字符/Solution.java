package com.字符流中第一个不重复的字符;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @Author: zt52875287@gmail.com
 * @Date: 2018/12/12
 */
public class Solution {
    StringBuilder sb = new StringBuilder();
    int bucket[] = new int[256];

    //Insert one char from stringstream
    public void Insert(char ch) {
        sb.append(ch);
        bucket[ch]++;
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (int i = 0; i < sb.length(); i++) {
            if (bucket[sb.charAt(i)]==1) {
                return sb.charAt(i);
            }
        }
        return '#';
    }
}
