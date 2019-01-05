package com.链表中环的入口节点;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.HashSet;

/**
 * @Author: zt52875287@gmail.com
 * @Date: 2018/12/1
 */
public class Solution {
    @Test
    public void test() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(8);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode5;
        EntryNodeOfLoop(listNode1);
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {

        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode s1 = pHead;
        ListNode s2 = s1.next;

        while (s2 != null) {

            if (s2.next != null) {
                s2 = s2.next;
                if (s2.val == s1.val) {
                    break;
                }
            } else {
                return null;
            }

            s1 = s1.next;
            s2 = s2.next;
        }


        int count = 1;
        while (s2.next != s1) {
            s2 = s2.next;
            count++;
        }


        s2 = pHead;
        s1 = pHead;
        while (count > 0) {
            s2 = s2.next;
            count--;
        }


        while (s1.val != s2.val) {
            s1 = s1.next;
            s2 = s2.next;
        }

        return s1;
    }
}
