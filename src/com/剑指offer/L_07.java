package com.剑指offer;

import java.util.HashMap;

public class L_07 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    int[] preorder;
    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recur(0,0, inorder.length - 1);
    }

    TreeNode recur(int root, int left,int right){
        if (left > right) return null;
        TreeNode node = new TreeNode(preorder[root]);
        int temp = map.get(preorder[root]);
        node.left = recur(root + 1,left,temp - 1);
        node.right = recur(root + temp - left + 1,temp + 1,right);
        return node;
    }
}
