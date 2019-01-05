package com.树的子结构;

public class Solution {

    public static void main(String[] args) {

    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        if (root1==null || root2==null)  return false;

        //先对比root1为跟的子树，在对比root1.left的子树，再对比root1.right的子树
        return  compare(root1,root2) || HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);



    }

    private boolean compare(TreeNode root1, TreeNode root2) {

        //出口，表示root2递归完毕，之前的节点都匹配成功
        if(root2==null) return true;
        if(root1==null) return false;

        //如果当前节点值相同，则继续递归比较子树
        return root1.val==root2.val && compare(root1.left,root2.left) && compare(root1.right,root2.right);
    }
}