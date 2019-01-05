package com.从尾到头打印链表;

import java.util.ArrayList;

/**
 * @Author: zt52875287@gmail.com
 * @Date: 2018/12/21
 */
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(0, listNode.val);
            listNode = listNode.next;
        }
        return list;

    }
}
