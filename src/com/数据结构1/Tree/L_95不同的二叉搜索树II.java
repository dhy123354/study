package com.数据结构1.Tree;

import java.util.LinkedList;
import java.util.List;

public class L_95不同的二叉搜索树II {
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

    //回溯法
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int strat,int end){
        List<TreeNode> list = new LinkedList<TreeNode>();
        if (strat > end){
            list.add(null);
            return list;
        }

        for (int i = strat;i <= end; i++){
            List<TreeNode> leftTrees = generateTrees(strat,i-1);

            List<TreeNode> rightTrees = generateTrees(i+1,end);

            for (TreeNode left: leftTrees){
                for (TreeNode right: rightTrees){
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    list.add(node);
                }
            }
        }
        return list;
    }
}
