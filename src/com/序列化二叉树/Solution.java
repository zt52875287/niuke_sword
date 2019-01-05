package com.序列化二叉树;

/**
 * @Author: zt52875287@gmail.com
 * @Date: 2018/12/16
 */
public class Solution {
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("#,");

        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    int index = -1;

    TreeNode Deserialize(String str) {
        index++;

        String[] arr = str.split(",");
        if (index >= arr.length || arr[index].equals("#")) {
            return null;
        }

        TreeNode treeNode = new TreeNode(Integer.parseInt(arr[index]));
        treeNode.left = Deserialize(str);
        treeNode.right = Deserialize(str);
        return treeNode;
    }
}





