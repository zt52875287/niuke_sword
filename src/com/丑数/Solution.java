package com.丑数;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    @Test
    public void test() {
        System.out.println(GetUglyNumber_Solution(10));
    }

    public int GetUglyNumber_Solution(int index) {
        if (index==0) return 0;
        int c2 = 0, c3 = 0, c5 = 0;
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);
        int count=1;
        int m2,m3,m5;
        int minOfThree;
        while (count<index){
            m2 = result.get(c2) * 2;
            m3 = result.get(c3) * 3;
            m5 = result.get(c5) * 5;
            minOfThree = findMin(m2, m3, m5);
            result.add(minOfThree);
            if(m2==minOfThree) c2++;
            if(m3==minOfThree) c3++;
            if(m5==minOfThree) c5++;
            count++;
        }

        System.out.println(result);
        return result.get(result.size()-1);
    }

    private int findMin(int a, int b, int c) {

        return a > b
                ?
                (b > c ? c : b)
                :
                (a < c ? a : c);
    }
}
