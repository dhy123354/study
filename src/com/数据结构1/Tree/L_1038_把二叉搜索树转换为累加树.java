package com.数据结构1.Tree;

public class L_1038_把二叉搜索树转换为累加树 {
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
    int num;
    public TreeNode bstToGst(TreeNode root) {
        while (root != null){
            bstToGst(root.right);
            num += root.val;
            root.val = num;
            bstToGst(root.left);
        }
        return root;
    }
}
