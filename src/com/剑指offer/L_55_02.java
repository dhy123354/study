package com.剑指offer;

public class L_55_02 {
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

    public boolean isBalanced(TreeNode node){
        return IsBalanced(node.right,0);
    }


    public boolean IsBalanced(TreeNode node,int d){
        if (node == null){
            d = 0;
            return true;
        }
        int left = 0,right = 0;
        if (IsBalanced(node.left,left) && IsBalanced(node.right,right)) {
            int diff = left - right;
            if (diff <= 1 && diff >= -1){
                d = 1 + (left > right ? left : right);
                return true;
            }
        }
        return false;
    }
}
