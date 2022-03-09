package com.剑指offer;

import java.util.ArrayList;
import java.util.List;

public class L_34 {
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

    List<List<Integer>> list = new ArrayList<>();
    List<Integer> integerList = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        place(root,target,root);
        return list;
    }

    public void place(TreeNode root,int target,TreeNode cur){
        if (cur == null) return;
        integerList.add(cur.val);
        if (target == cur.val && cur.left == null && cur.right == null) {
            list.add(new ArrayList<>(integerList));
        }
        place(root,target - cur.val,cur.left);
        place(root,target- cur.val,cur .right);
        integerList.remove(integerList.size() - 1);
    }

}
