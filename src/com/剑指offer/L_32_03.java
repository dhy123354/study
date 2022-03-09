package com.剑指offer;

import java.util.*;

public class L_32_03 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        int flag = 0;
        while (!queue.isEmpty()) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int size = queue.size(); size > 0; size--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (flag % 2 == 1)
                Collections.reverse(tmp);
            flag++;
            lists.add(tmp);
        }
        return lists;
    }
}
