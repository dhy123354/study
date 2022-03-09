package com.数据结构1.Tree;



import java.util.LinkedList;
import java.util.Queue;

public class L_104_二叉树的最大深度 {
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
    //迭代方法
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();

        int height = 0;
        int levelsize = 1 ;
        int num = 0;

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            levelsize--;
            for (int i = 0; i < queue.size(); i++) {
                if (node.left != null){
                    queue.offer(node.left);
                }

                if (node.right != null){
                    queue.offer(node.right);
                }

                if (levelsize == 0){
                    levelsize = queue.size();
                    height++;
                }
            }
        }
        return height;
    }

    //递归方法
    public int maxDepth(TreeNode root){
        return maxDepth(root);
    }

    public int dfs(TreeNode node){
        if (node == null) return 0;
        return 1 + Math.max(maxDepth(node.left),maxDepth(node.right));
    }
}
