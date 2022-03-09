package com.数据结构1.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L_107二叉树的层序遍历II {
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

    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> list1 = new LinkedList<>();
            for (int i = 1; i <= queue.size(); ++i){
                TreeNode node = queue.poll();
                list1.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            list.add(0,list1);
        }
        return list;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> list1 = new LinkedList<>();
            for (int i = 1; i <= queue.size(); ++i){
                TreeNode node = queue.poll();
                list1.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            list.add(0,list1);
        }
        return list;
    }

}
