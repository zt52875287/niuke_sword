package com.二叉搜索树的第K个节点;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;

/**
 * @Author: zt52875287@gmail.com
 * @Date: 2018/12/10
 */
public class Solution {
    @Test
    public void test() {
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(9);
        TreeNode t7 = new TreeNode(20);
        TreeNode t8 = new TreeNode(1);
        TreeNode t9 = new TreeNode(4);


        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t4.left = t8;
        t4.right = t9;

        TreeNode ans = KthNode(t1, 4);

        System.out.println(ans.val);

    }

    int counter = 0;

    TreeNode KthNode(TreeNode pRoot, int k) {

        if (pRoot != null) {
            TreeNode node = KthNode(pRoot.left, k);
            if (node != null) {
                return node;
            }

            counter++;
            if (counter == k) {
                return pRoot;
            }

            node = KthNode(pRoot.right, k);
            if (node != null) {
                return node;
            }

        }
        return null;


    }

}
