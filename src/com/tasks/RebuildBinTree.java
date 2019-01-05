package com.tasks;

import com.util.TreeNode;

import java.util.Arrays;

public class RebuildBinTree {


    /**
     * Definition for binary tree
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public static void main(String[] args) {
        int[] ints = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] ints1 = {4, 7, 2, 1, 5, 3, 8, 6};

        TreeNode treeNode = reConstructBinaryTree(ints, ints1);
        show(treeNode);
    }

    private static void show(TreeNode treeNode) {
        System.out.println(treeNode.val);
        System.out.println(treeNode.left == null ? "null" : "left not null");
        System.out.println(treeNode.right == null ? "null" : "right not null");

        if (treeNode.left != null) {
            System.out.println("遍历 " + treeNode.val + " 左");
            show(treeNode.left);
        }
        if (treeNode.right != null) {
            System.out.println("遍历 " + treeNode.val + " 右");
            show(treeNode.right);
        }


    }


    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        int parent = pre[0];
        TreeNode treeNode = new TreeNode(parent);
        for (int j = 0; j < in.length; j++) {
            if (parent == in[j]) {
                //如果当前数组长度为1，则返回当前node,则跳出循环，返回当前node。否则继续递归遍历
                if (pre.length > 1) {
                    //左子树不为空
                    if (j != 0) {
                        TreeNode treeNode1 = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, j + 1), Arrays.copyOfRange(in, 0, j));
                        treeNode.left = treeNode1;
                    }
                    //右子树不为空
                    if (1 + j != pre.length) {
                        TreeNode treeNode2 = reConstructBinaryTree(Arrays.copyOfRange(pre, 1 + j, pre.length), Arrays.copyOfRange(in, j + 1, in.length));
                        treeNode.right = treeNode2;
                    }
                }


                //已在in种找到了pre的根节点，遍历完毕，不需要再比较in中的数字了，跳出循环，节省时间
                break;
            }
        }
        return treeNode;
    }
}
