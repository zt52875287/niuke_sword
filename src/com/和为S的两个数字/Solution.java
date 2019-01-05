package com.和为S的两个数字;

import com.tasks.FindLastLinkNode;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    @Test
    public void test() {
        int[] ints = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        System.out.println(FindNumbersWithSum(ints, 12).toString());

        Arrays.sort(ints);
    }

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array.length <= 1) return res;

        int low = 0;
        int high = array.length-1;

        while (low < high) {
            if (array[low] + array[high] == sum) {
                res.add(array[low]);
                res.add(array[high]);
            } else if (array[low] + array[high]>sum) {
                high--;
            } else {
                low++;
            }
        }

        return res;
    }
}