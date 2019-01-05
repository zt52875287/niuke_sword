package com.最小的K个数;

import org.junit.Test;

import java.util.ArrayList;

public class Solution {
    @Test
    public void test() {
        int[] ints = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> list = GetLeastNumbers_Solution(ints, 6);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

        ArrayList<Integer> list = new ArrayList<>();
        if (k>input.length){
            return list;
        }
        heapSort(input);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }

        return list;
    }

    public void heapSort(int arr[]) {

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust(arr, i, arr.length );
        }


        int tmp;
        for (int i = 0; i < arr.length; i++) {
            tmp = arr[0];
            arr[0] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
            adjust(arr, 0, arr.length - 1 - i);
        }

    }

    public void adjust(int[] arr, int start, int len) {

        int root = arr[start];

        for (int child = 2 * start + 1; child < len; child = child * 2 + 1) {

            if (child + 1 < len && arr[child] < arr[child + 1]) child++;

            if (root > arr[child]) break;

            arr[start] = arr[child];
            start = child;

        }

        arr[start] = root;

    }

}
