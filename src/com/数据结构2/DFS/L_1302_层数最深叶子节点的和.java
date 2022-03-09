package com.数据结构2.DFS;

import java.util.LinkedList;
import java.util.Queue;

public class L_1302_层数最深叶子节点的和 {
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

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int num = 0;
        queue.offer(root);
        while (!queue.isEmpty()){
            num = 0;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = new TreeNode();
                node = queue.poll();
                num += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return num;
    }
}
