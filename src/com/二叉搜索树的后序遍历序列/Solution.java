package com.二叉搜索树的后序遍历序列;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    @Test
    public void test() {
//        System.out.println(VerifySquenceOfBST(new int[]{7, 4, 6, 5}));
//        System.out.println(VerifySquenceOfBST(new int[]{4,8,6,12,16,14,10}));
        System.out.println(VerifySquenceOfBST(new int[]{4,8,6,10}));
    }


    public boolean VerifySquenceOfBST(int[] sequence) {
        return sequence.length>0 && Verify(sequence, 0, sequence.length - 1) ;
    }

    public boolean Verify(int[] sequence, int start, int end) {

        /**
         * 注意子树为空和右子树为空的情况，此处“>”就是用来限制右子树为空的情况
         */
        if (start >= end) return true;

        int pivot = end-1;
        int node = sequence[end];

        while (pivot >= start && sequence[pivot] > node) pivot--;

        for (int i = pivot; i >= start; i--) {
            if (sequence[i] > node) {
                return false;
            }
        }

        return Verify(sequence,start,pivot) && Verify(sequence,pivot+1,end-1);

    }
}
