package com.数据结构1.Tree;

import java.util.Deque;
import java.util.LinkedList;

public class L_105_从前序与中序遍历序列构造二叉树 {
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
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIn = 0;
        for(int i = 0;i < preorder.length;i++){
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIn]){
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            }else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIn]){
                    node = stack.pop();
                    inorderIn++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
