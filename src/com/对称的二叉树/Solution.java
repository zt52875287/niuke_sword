package com.对称的二叉树;

/**
 * @Author: zt52875287@gmail.com
 * @Date: 2018/12/2
 */
public class Solution {

    boolean isSymmetrical(TreeNode pRoot) {

        if (pRoot == null) {
            return true;
        }

        return compare(pRoot.left, pRoot.right);

    }

    private boolean compare(TreeNode lChild, TreeNode rChild) {

        if (lChild == null && rChild == null) {
            return true;
        }

        //上一步过滤掉了两个节点都为空的情况，这一步保证两个节点都不为空（因为下一步要调用val方法，如果为空，就会异常）
        if (lChild == null ^ rChild == null) {
            return false;
        }

        return lChild.val == rChild.val && compare(lChild.left, rChild.right) && compare(lChild.right, rChild.left);

    }
}
