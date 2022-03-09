package com.数据结构1.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class L_226_翻转二叉树 {
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
//   //前序便利
//    public TreeNode invertTree(TreeNode root) {
//        if (root == null) return root;
//
//        TreeNode tmp = root.left;
//        root.left = root.right;
//        root.right = tmp;
//
//        invertTree(root.left);
//        invertTree(root.right);
//
//        return root;
//    }

//    //中序便利
//    public TreeNode invertTree(TreeNode root){
//        if (root == null) return root;
//        invertTree(root.left);
//
//        TreeNode tmp = root.left;
//        root.left = root.right;
//        root.right = tmp;
//
//        invertTree(root.left);
//
//        return root;
//    }
    //层序便利
    public TreeNode invertTree(TreeNode root){
        if (root == null) return root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if (node.left!=null){
                queue.offer(node.left);
            }
            if (node.right!=null){
                queue.offer(node.right);
            }
        }
        return root;
    }
}
