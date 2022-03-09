package com.数据结构1.Tree;

public class 前序遍历与中序遍历构造二叉树 {

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return new TreeNode(-1);
        TreeNode root = new TreeNode(preorder[0]);
        return null;
    }
}
