package com.两个链表的第一个公共节点;

import com.util.ListNode;

import java.util.HashSet;

public class Solution {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead2 == null || pHead1 == null) return null;
        HashSet<ListNode> set = new HashSet<>();

        while (pHead1 != null) {
            set.add(pHead1);
            pHead1 = pHead1.next;
        }
        int len = set.size();
        while (pHead2 != null) {
            set.add(pHead2);
            if (len == set.size()) {
                return pHead2;
            }
            pHead2 = pHead2.next;
            len++;
        }
        return null;

    }


}
