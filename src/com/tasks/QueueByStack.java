package com.tasks;

import java.util.Stack;

public class QueueByStack {


    public static void main(String[] args) {

        push(1);
        push(2);
        push(3);
        push(9);
        push(4);


        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());

    }

    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();

    public static void push(int node) {

        if (stack2.empty()) {
            stack1.push(node);
        } else {
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
            stack1.push(node);
        }
    }

    public static int pop() {

        if (!stack2.empty()) {
            return stack2.pop();
        } else {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }

        }
        return stack2.pop();
    }

}
