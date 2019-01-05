package com.复杂链表的复制;

public class Solution {

    /**
     * 题目要求
     * 1. 所有的nex节点复制一份
     * 2. 所有的random节点复制一份(random后面连接的节点都是引用,不做复制)
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead) {

        if (null==pHead) return null;

        RandomListNode node = new RandomListNode(pHead.label);
        /**
         * 用递归复制next节点
         */
        if (pHead.next!=null){
            node.next=Clone(pHead.next);
        }
        /**
         * 复制random节点.这里不使用递归,原因是:
         * 对于一个节点node来说,只有node.random是new出来的,但是这个几点后面连接的节点都是引用
         * 如果使用递归,就会将random后面链接的节点全部复制,这与题意不服
         */
        if (pHead.random!=null){
            node.random=getRandom(pHead.random);
        }
        return node;
    }

    public RandomListNode getRandom(RandomListNode pHead) {
        RandomListNode node = new RandomListNode(pHead.label);
        node.next=pHead.next;
        node.random=pHead.random;
        return node;
    }


}