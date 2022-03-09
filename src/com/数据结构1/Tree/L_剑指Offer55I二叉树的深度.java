package com.数据结构1.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class L_剑指Offer55I二叉树的深度 {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
    //文件流.递归
    public int maxDepth1(TreeNode root) {
      if (root == null) return 0;
      int height = 0;
      return height = Math.max(height,Math.max(maxDepth1(root.left),maxDepth1(root.right)));
    }

    //非递归
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int height = 0;
        int levlsize = 1;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            levlsize--;

            if (node.left != null){
                queue.offer(node.left);
            }

            if (node.right != null){
                queue.offer(node.right);
            }

            if (levlsize == 0){
                levlsize = queue.size();
                height++;
            }
        }
        return height;
    }
}
