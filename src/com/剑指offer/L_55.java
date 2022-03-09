package com.剑指offer;

import java.util.LinkedList;
import java.util.Queue;

public class L_55 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int height = 0;
        int levelSize = 1;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            levelSize--;
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
            if (levelSize == 0){
                levelSize = queue.size();
                height++;
            }
        }
        return height;
    }

    public int maxDepth(TreeNode root){
        if (root ==  null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return left > right ? (left + 1) : (right + 1);
    }
}