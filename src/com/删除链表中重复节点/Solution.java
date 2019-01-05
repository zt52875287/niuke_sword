package com.删除链表中重复节点;

import org.junit.Test;

/**
 * @Author: zt52875287@gmail.com
 * @Date: 2018/11/28
 */
public class Solution {

    // 1 2 3 3 4 4 5

    @Test
    public void test() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode7 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;

        ListNode r = deleteDuplication(listNode1);
        while (r != null) {
            System.out.print(r.val + " ");
            r = r.next;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        if (pHead.val == pHead.next.val) {
            while (pHead.next!=null && pHead.val == pHead.next.val) {
                pHead = pHead.next;
            }
            pHead = pHead.next;
            pHead=deleteDuplication(pHead);
        } else {
            pHead.next=deleteDuplication(pHead.next);
        }

        return pHead;
    }
}
