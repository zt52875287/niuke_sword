package com.二叉树的下一个节点;

import java.util.ArrayList;

/**
 * @Author: zt52875287@gmail.com
 * @Date: 2018/12/7
 */
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {

        TreeLinkNode root = pNode;
        while (root.next != null) {
            root = root.next;
        }

        ArrayList<TreeLinkNode> list = new ArrayList<>();
        midSearch(root, list);

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i) == pNode) {
                if (i + 1 < list.size()) {
                    return list.get(i + 1);
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    private void midSearch(TreeLinkNode root, ArrayList<TreeLinkNode> list) {
        if (root.left != null) {
            midSearch(root.left, list);
        }
        list.add(root);
        if (root.right != null) {
            midSearch(root.right, list);
        }
    }
}