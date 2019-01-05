package com.从上往下打印二叉树;


import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class Solution {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();

        if (root==null) return result;

        queue.add(root);

        while (queue.size() > 0) {

            TreeNode node = queue.get(0);

            if (node.left!=null) queue.add(node.left);
            if (node.right!=null) queue.add(node.right);

            result.add(node.val);

            queue.remove(0);
        }

        return result;

    }
}
