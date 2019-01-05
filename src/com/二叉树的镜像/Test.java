package com.二叉树的镜像;


/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
 */
public class Test {

    /*
    非递归
     */
    public void Mirror(TreeNode root) {

        if (root == null) {
            return;
        }

        TreeNode head = root;

        while (root.right != null || root.left != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;


            if(root.right!=null){
                root = root.right;
            }
            if (root.left != null) {
                root = root.left;
            }
        }


    }

/*
递归
 */

    public void Mirror2(TreeNode root) {

        if (root == null) {
            return;
        }

        if (root.left != null || root.right != null) {

            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;

            if (root.left != null) {
                Mirror2(root.left);
            }
            if (root.right != null) {
                Mirror2(root.right);
            }
        }

    }
}
