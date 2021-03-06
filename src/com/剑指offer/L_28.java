package com.剑指offer;

public class L_28 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root,root);
    }

    public boolean isSymmetric(TreeNode left,TreeNode right){
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isSymmetric(left.left,right.right) &&
                isSymmetric(left.right,right.left);
    }
}
