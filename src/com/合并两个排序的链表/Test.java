package com.合并两个排序的链表;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Test {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(115);
        ListNode l2 = new ListNode(116);
        ListNode l3 = new ListNode(127);
        ListNode l4 = new ListNode(138);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListNode l2_1 = new ListNode(221);
        ListNode l2_2 = new ListNode(222);
        ListNode l2_3 = new ListNode(233);

        l2_1.next = l2_2;
        l2_2.next = l2_3;

        ListNode merge = Merge(l1, l2_1);

        while (merge != null) {
            System.out.println(merge.val);
            merge = merge.next;
        }


    }
    /*
    两种方案
     */
    /*
    非递归
    */
    public static ListNode Merge(ListNode list1, ListNode list2) {

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head;
        ListNode tail;

        if (list1.val > list2.val) {
            head = list2;
            list2 = list2.next;
        } else {
            head = list1;
            list1 = list1.next;
        }
        tail = head;

        while (list1 != null && list2 != null) {

            if (list1.val > list2.val) {
                tail.next = list2;
                list2 = list2.next;
            } else {
                tail.next = list1;
                list1 = list1.next;
            }
            tail = tail.next;
        }

        if (list1 == null) {
            tail.next = list2;

        }
        if (list2 == null) {
            tail.next = list1;
        }
        return head;
    }

    /*
    递归
     */
    /*public static ListNode Merge1(ListNode list1, ListNode list2) {

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }

    }*/
}
