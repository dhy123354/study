package com.数据结构1.Tree;

import java.util.Deque;
import java.util.LinkedList;

public class L_662二叉树最大宽度 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> queue = new LinkedList<>();
        root.val = 0;
        queue.offer(root);

        int count;
        int Maxwidth = 0;

        while (!queue.isEmpty()){
            count = queue.size();
            Maxwidth = Math.max(Maxwidth,queue.getLast().val-queue.getFirst().val+1);

            while (count > 0){
                TreeNode node = queue.poll();
                if (node.left!=null){
                    queue.offer(node.left);
                    node.left.val = node.val*2 + 1;
                }
                if (node.right!=null){
                    queue.offer(node.right);
                    node.right.val = node.val*2 + 2;
                }
                count--;
            }
        }
        return Maxwidth;
    }
}
