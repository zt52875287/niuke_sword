package com.二叉树的深度;


import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * public class TreeNode {
 * int val = 0;
 * TreeNode left = null;
 * TreeNode right = null;
 * <p>
 * public TreeNode(int val) {
 * this.val = val;
 * <p>
 * }
 * <p>
 * }
 */
public class Solution {
    @Test
    public void test() {

        TreeNode n1 = new TreeNode(11);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(12);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        System.out.println(TreeDepth(n1));


    }

    //递归
    public int TreeDepth1(TreeNode root) {
        if (root == null) return 0;

        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);

        return 1 + Math.max(left, right);

    }

    //非递归，广度优先搜做
    public int TreeDepth(TreeNode root) {
        if (root==null) return 0;
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        queue1.addFirst(root);

        int depth = 0;

        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            depth++;
            if (!queue1.isEmpty()) {
                while (!queue1.isEmpty()) {
                    TreeNode treeNode = queue1.removeFirst();
                    if (treeNode.left != null) {
                        queue2.addFirst(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue2.addFirst(treeNode.right);
                    }
                }

            } else {
                while (!queue2.isEmpty()) {
                    TreeNode treeNode = queue2.removeFirst();
                    if (treeNode.left != null) {
                        queue1.addFirst(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue1.addFirst(treeNode.right);
                    }
                }
            }

        }
        return depth;
    }


}