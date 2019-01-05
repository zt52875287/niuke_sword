package com.数字在排序数组中出现的次数;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        int []a={3,3,3,3};
        System.out.println(GetNumberOfK(a, 3));
    }
    public int GetNumberOfK(int[] array, int k) {

        //非递归二分查找
//        int position = getPosition1(array, k);
        //递归二分查找
        int position = getPosition2(array, 0, array.length-1,k);

        if (position==-1) return 0;

        int first=position;
        int last=position;

        for (int i = position+1; i < array.length; i++) {
            if (array[i]!=k){
                last = i-1;
                break;
            }else{
                last=i;
            }
        }
        for (int i = position-1; i >=0; i--) {
            if (array[i]!=k){
                first = i+1;
                break;
            }else{
                first=i;
            }
        }

        return last-first+1;
    }

    private int getPosition2(int[] array, int low, int high, int k) {

        if (low>high) return -1;
        int mid = (low+high)/2;
        if (array[mid]==k){
            return mid;
        }else if(array[mid]<k){
            return getPosition2(array, mid + 1, high, k);
        }else{
            return getPosition2(array, low, mid-1, k);
        }
    }

    private int getPosition1(int[] array, int k) {
        int low = 0;
        int high = array.length-1;
        int mid;

        while (low<=high){
            mid = (low+high)/2;
            if (array[mid]>k) {
                high =mid-1;
            }else if(array[mid]<k){
                low=mid+1;
            }else{
                return mid;
            }
        }

        return -1;
    }

}