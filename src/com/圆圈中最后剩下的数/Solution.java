package com.圆圈中最后剩下的数;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @Author: zt52875287@gmail.com
 * @Date: 2018/12/4
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(LastRemaining_Solution(5, 3));
    }

    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m <= 0) return -1;

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int toDel = m-1;
        int preDel = 0;
        for (int i = n-1; i > 0; i--) {
            toDel = preDel + m-1;
            while (toDel >= list.size()) {
                toDel = toDel % list.size();
            }
            list.remove(toDel );
            preDel = toDel;
        }
        return list.get(0);
    }
}
