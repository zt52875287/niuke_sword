package com.tasks;

import javax.swing.*;
import java.util.Stack;

public class FindLastLinkNode {


    /*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        System.out.println(FindKthToTail_indicator(listNode, 5).val);
        System.out.println(FindKthToTail_stack(listNode, 5).val);
    }


    /*
    两个思路：
    1. 快慢指针
    2. 栈

     */
    private static ListNode FindKthToTail_stack(ListNode listNode, int k) {
        Stack<ListNode> nodes = new Stack<>();

        while (listNode != null) {

            nodes.push(listNode);
            if (listNode.next != null) {
                listNode = listNode.next;
            }else{
                break;
            }

        }

        for (int j = 0; j < k; j++) {
            if (!nodes.empty()) {
                if (j == k - 1) {
                    return nodes.pop();
                } else {
                    nodes.pop();
                }
            } else {
                return null;
            }
        }

        return null;

    }

    public static ListNode FindKthToTail_indicator(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }

        ListNode first = head;

        for (int i = 0; i < k - 1; i++) {
            if (head.next != null) {
                head = head.next;
            } else {
                return null;
            }
        }

        while (head.next != null) {
            head = head.next;
            first = first.next;
        }

        return first;

    }
}
