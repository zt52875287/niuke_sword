package com.栈的压入弹出序列;

import java.util.Stack;
import java.util.concurrent.ForkJoinPool;

public class Solution {

    public static void main(String[] args) {

        int[] a = {1,2,3,4,5};

        int[] b = {4,5,3,2,1};
        System.out.println(IsPopOrder(a,b));
    }

    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        if (popA.length==0||pushA.length==0||popA.length!=pushA.length){
            return false;
        }
        int popIndex=0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.empty()&&stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            }

        }

        return stack.empty();
    }
}