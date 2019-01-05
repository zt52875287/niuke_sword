package com.包含min函数的栈;

import java.util.Stack;

public class Solution {
    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();


    public void push(int node) {

        if (min.empty() || node<=min()){
            min.push(node);
            data.push(node);
        }else{
            data.push(node);
        }

    }

    public void pop() {
        if (min() == top()) {
            min.pop();
        }
        data.pop();

    }

    public int top() {
        return data.peek();
    }

    public int min() {

        Integer m = min.pop();
        min.push(m);
        return m;
    }
}
