package com.把二叉树打印成多行;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @Author: zt52875287@gmail.com
 * @Date: 2018/12/10
 */

public class Solution {
    @Test
    public void test() {
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        TreeNode treeNode = null;
        treeNodes.add(treeNode);
        System.out.println("size=" + treeNodes.size());
    }


    ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) return result;

        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(pRoot);

        while (queue.size() > 0) {

            int count = queue.size();
            ArrayList<Integer> layer = new ArrayList<>();


            for (int i = 0; i < count; i++) {

                TreeNode node = queue.remove(0);
                layer.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            result.add(layer);
        }

        return result;
    }


    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        travel(pRoot, 1, result);
        return result;
    }

    public void travel(TreeNode pRoot, int depth, ArrayList<ArrayList<Integer>> result) {

        if (pRoot==null) return;

        if (depth > result.size()) {
            result.add(new ArrayList<>());
        }

        result.get(depth - 1).add(pRoot.val);

        if (pRoot.left != null) travel(pRoot.left, depth + 1, result);
        if (pRoot.right != null) travel(pRoot.right, depth + 1, result);

    }
}
