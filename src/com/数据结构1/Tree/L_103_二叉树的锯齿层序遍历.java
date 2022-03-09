package com.数据结构1.Tree;

import java.util.*;

public class L_103_二叉树的锯齿层序遍历 {

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

    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()){
            List<Integer> list1 = new ArrayList<>();
            int count = queue.size();
            for (int i = 1; i <= count; i++) {
                TreeNode treeNode = queue.poll();
                if (flag){
                    list1.add(treeNode.val);
                }else {
                    list1.add(0,treeNode.val);
                }
                if(treeNode.right != null){
                    queue.offer(treeNode.right);
                }
                if(treeNode.left != null){
                    queue.offer(treeNode.left);
                }
            }
            flag = !flag;
            list.add(list1);
        }
        return list;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int flag = 1;
        while (!queue.isEmpty()){
            List<Integer> list1 = new ArrayList<>();
            int count = queue.size();
            for (int i = 1; i <= count; i++) {
                TreeNode treeNode = queue.poll();
                list1.add(treeNode.val);
                if(treeNode.left != null){
                    queue.offer(treeNode.left);
                }
                if(treeNode.right != null){
                    queue.offer(treeNode.right);
                }
            }
            if (flag % 2 == 1) Collections.reverse(list);
            flag++;
            list.add(list1);
        }
        return list;
    }
}
