package com.数据结构1.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class L_700_二叉搜索树中的搜索 {
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

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode root1 = null;

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }

            if (node.val == val){
                root1 = node;
            }
        }
        return root1;
    }
}
