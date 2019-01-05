package com.按之字形顺序打印二叉树;

import java.util.ArrayList;

/**
 * @Author: zt52875287@gmail.com
 * @Date: 2018/12/12
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        travel(pRoot, 1, result);
        return result;
    }

    private void travel(TreeNode pRoot, int depth, ArrayList<ArrayList<Integer>> result) {
        if (pRoot == null) {
            return;
        }

        if (result.size() < depth) {
            result.add(new ArrayList<Integer>());
        }
        if (depth % 2 == 0) {
            result.get(depth - 1).add(0, pRoot.val);
        } else {
            result.get(depth - 1).add(pRoot.val);
        }

        travel(pRoot.left,depth+1,result);
        travel(pRoot.right,depth+1,result);


    }

}
