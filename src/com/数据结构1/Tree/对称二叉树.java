package com.数据结构1.Tree;

public class 对称二叉树 {

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

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return isTrue(root.left,root.right);
    }

    public boolean isTrue(TreeNode leftNode,TreeNode rightNode){
        if (leftNode == null && rightNode == null) return true;
        if (leftNode == null || rightNode == null ||
                leftNode.val != rightNode.val){
            return false;
        }

        return isTrue(leftNode.left,rightNode.right)
                && isTrue(leftNode.right,rightNode.left);
    }

    private boolean cmp(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        }
        return cmp(node1.left, node2.right) && cmp(node1.right, node2.left);
    }

}
