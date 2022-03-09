package com.数据结构2.递归.L_894;

import java.util.LinkedList;
import java.util.List;

public class _所有可能的满二叉树 {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }
    /*
        1.提供一种构建二叉树的方法
        2.递归的三个构造条件
     */

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> list = new LinkedList<>();
        if (n % 2 == 0) return list;

        if (n == 1){
            TreeNode root = new TreeNode(0);
            list.add(root);
            return list;
        }

        for (int i = 1; i < n; i+=2) {
            for (TreeNode left : allPossibleFBT(i)){
                for (TreeNode right : allPossibleFBT(n - 1 - i)){
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
