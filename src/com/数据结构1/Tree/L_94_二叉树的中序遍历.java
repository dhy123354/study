package com.数据结构1.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class L_94_二叉树的中序遍历 {
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


    public void inorder(TreeNode root, List<Integer> list){
        if (root == null) return ;

        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }

    private List<Integer> list = new ArrayList<>();
    //递归2
    public List<Integer> inorderTraversal3(TreeNode root){
        if (root == null) return list;
        inorderTraversal3(root.left);
        list.add(root.val);
        inorderTraversal3(root.right);
        return list;
    }


    //迭代1
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()){
            if (node != null){
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;
    }
}
