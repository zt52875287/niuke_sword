package com.二叉搜索树与双向链表;

import com.从上往下打印二叉树.TreeNode;
import org.junit.Test;

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

        TreeNode ans = Convert(t1);
        while (ans.right != null) {
            System.out.print(ans.val + " ");
            ans = ans.right;
        }
        System.out.println(ans.val);

    }

    TreeNode treeNode = null;

    public TreeNode Convert(TreeNode pRootOfTree) {

        if (pRootOfTree == null) return null;

        //先序遍历,并修改前驱指针
        midOrderSearch(pRootOfTree);

        //此时，链表的前驱指针都已经搞定，次啊来需要从尾巴开始向前走，调整每个节点的后继指针
        //找到尾结点
        TreeNode tail = null;
        while (pRootOfTree.right != null) {
            pRootOfTree = pRootOfTree.right;
        }
        tail = pRootOfTree;

        //从后向前，调整单向链表的后继指针
        TreeNode current = tail;

        while (current.left != null) {
            //让前驱节点的后继指针指向自身
            current.left.right = current;
            current = current.left;
        }
        return current;
    }


    private void midOrderSearch(TreeNode root) {

        if (root.left != null) {
            midOrderSearch(root.left);
        }

        if (treeNode == null) {
            treeNode = root;
        } else {
            //调整前驱指针
            root.left = treeNode;
            treeNode = root;
        }

        if (root.right != null) {
            midOrderSearch(root.right);
        }

    }
}
