package com.数据结构1.Tree;

public class L_110_平衡二叉树 {
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
    public int  height(TreeNode root) {
        if (root == null) return 0;
        int height ;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (Math.abs(leftHeight-rightHeight) <= 1 && leftHeight >=0 &&rightHeight>=0 ){
            return 1 + Math.max(leftHeight,rightHeight);
        }
        return -1;
    }

    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }
}