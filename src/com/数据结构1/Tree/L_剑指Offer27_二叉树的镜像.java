package com.数据结构1.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class L_剑指Offer27_二叉树的镜像 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //迭代
    public TreeNode mirrorTree1(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return root;
    }

    //文件流.递归
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;

        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.right = left;
        right.left = right;
        return root;
    }
}
