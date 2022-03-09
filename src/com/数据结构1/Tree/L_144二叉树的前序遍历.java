package com.数据结构1.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L_144二叉树的前序遍历 {
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
    //文件流.递归
    private List<Integer> list = new ArrayList<>();

    public List<Integer> preorderTraversalq(TreeNode root) {
        if (root == null) return list;
        list.add(root.val);
        preorderTraversalq(root.left);
        preorderTraversalq(root.right);
        return list;
    }

    public List<Integer> preorderTraversal3(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()){
            if (node != null ){
                list.add(node.val);
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                node = node.right;
            }
        }
        return list;
    }

    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();

            list.add(node.val);
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }
        return list;
    }

}
