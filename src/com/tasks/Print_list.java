package com.tasks;

/*
输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。

public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/

import java.util.ArrayList;
import java.util.Stack;

public class Print_list {
    public static void main(String[] args) {
//        ListNode ln1 = null;

        System.out.println("start...");

        ListNode ln1 = new ListNode(6);
        ListNode ln2 = new ListNode(7);
        ListNode ln3 = new ListNode(8);
        ListNode ln4 = new ListNode(9);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;

        System.out.println("start method");

        System.out.println(printListFromTailToHead(ln1));

        System.out.println("end");
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> result = new ArrayList<>();

        if (listNode!=null) {

            result.addAll(printListFromTailToHead(listNode.next));
            result.add(listNode.val);

        }

        return result;
    }

}
