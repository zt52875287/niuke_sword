package com.二叉树中和为某一值的路径;

import org.junit.Test;

import java.util.ArrayList;

public class Solution {
    @Test
    public void test() {
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(12);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        ArrayList<ArrayList<Integer>> arrayLists = FindPath(n1, 22);
        for (ArrayList<Integer> arrayList : arrayLists) {
            for (Integer integer : arrayList) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

    }

    public void find(TreeNode root, int target, ArrayList<Integer> values, ArrayList<ArrayList<Integer>> result) {

        values.add(root.val);

        if (target == root.val && root.right == null && target == root.val) {
            result.add(new ArrayList<>(values));
            return;
        }

        if (root.left != null) {
            find(root.left, target - root.val, values, result);
            values.remove(values.size() - 1);
        }
        if (root.right != null) {
            find(root.right, target - root.val, values, result);
            values.remove(values.size() - 1);
        }

        return;
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        ArrayList<Integer> values = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        find(root, target, values, result);

        return result;
    }
}
