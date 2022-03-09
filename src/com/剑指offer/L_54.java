package com.剑指offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L_54 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int kthLargest1(TreeNode root, int k) {
        if (root == null || k < 1) return -1;
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.right;
            } else {
                node = stack.pop();
                if (count++ == k)return node.val;
                node = node.left;
            }
        }
        return -1;
    }

    int ans = 0;
    int count = 0;
    public int kthLargest(TreeNode root, int k) {
        inorder(root,k);
        return ans;
    }

    private void inorder(TreeNode root,int k){
        if (root == null) return;

        inorder(root.right,k);
        if (++count == k) {
            ans = root.val;
            return;
        }
        inorder(root.left,k);
    }
}