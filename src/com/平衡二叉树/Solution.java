package com.平衡二叉树;

import com.从上往下打印二叉树.TreeNode;
import org.junit.Test;

public class Solution {

    @Test
    public void test(){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(11);
        TreeNode n3 = new TreeNode(12);
        TreeNode n4 = new TreeNode(13);

        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        t3.left=t6;
        t3.right=t7;
        t4.left=t8;
        t4.right=t9;
        t5.left=n1;
        t5.right=n2;
        System.out.println(IsBalanced_Solution(t1));

    }

    public boolean IsBalanced_Solution(TreeNode root) {

        if (root ==null){
            return true;
        }
        return Math.abs(  maxDepth(root.left)-maxDepth(root.right)) <= 1;

    }

    private int maxDepth(TreeNode node) {

        if (node==null) return 0;
        System.out.print(node.val+ " ");
        return 1 + Math.max( maxDepth(node.left),maxDepth(node.right));
    }

}
