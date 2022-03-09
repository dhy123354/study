package com.数据结构1.Tree;

import com.sun.org.apache.bcel.internal.generic.LLOAD;

public class 恢复二叉搜索树 {

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

   TreeNode firstNode = null;
   TreeNode secondNode = null;
   TreeNode preNode = new TreeNode(Integer.MAX_VALUE);

    public void recoverTree(TreeNode root) {
        if (root == null) return;
        dfs(root);
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }

    public void dfs(TreeNode node){
        if (node == null) return;
        dfs(node.left);
        if (firstNode == null && preNode.val > node.val) firstNode = preNode;
        if (firstNode != null && preNode.val > node.val) secondNode = node;
        preNode = node;
        dfs(node.right);
    }
}
