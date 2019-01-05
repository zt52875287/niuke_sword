package com.tasks;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class AdjustArray {

    public static void main(String[] args) {
        int[] ints = {2, 4, 6, 1, 3, 5, 7};
        reOrderArray_enh(ints);
        System.out.println(Arrays.toString(ints));
    }

    /*
    空间换时间，空间复杂度O(n),时间复杂度o(n)
    先找出数组中奇数的个数oddcount，然后新建空数组，在遍历原数组时，遇到奇数从头插入，遇到偶数插入到oddcount以后的位置

     */

    public static void reOrderArray_enh(int[] array) {

        if (array.length==0 || array.length==1) return;


        int oddCount = 0;
        int[] newArr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                oddCount++;
            }
        }


        int oddStart=0;
        int evenStart=oddCount;

        for (int i = 0; i < array.length; i++) {
            if((array[i]&1)==1){
                newArr[oddStart++] = array[i];
            }else{
                newArr[evenStart++] = array[i];
            }
        }


        for (int i = 0; i < array.length; i++) {
            array[i]=newArr[i];
        }
    }

    public static void reOrderArray(int[] array) {

        int len = array.length;
        for (int i = 0; i < len; i++) {

            for (int j = 0; j < len - 1; j++) {

                if (array[j] % 2 == 0 && array[j + 1] % 2 == 1) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                } else if (array[j] % 2 == 1 && array[j + 1] % 2 == 1) {
                    j++;
                }

            }
        }

    }
}
