package com.剑指offer;

import java.util.LinkedList;
import java.util.Queue;

public class L_26 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean result = false;
        if(A == null || B == null) return false;
        return isEqual(A, B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    public boolean isEqual(TreeNode node1,TreeNode node2){
        if (node2 == null) return true;
        if (node1 == null) return false;
        return isEqual(node1.left, node2.left) &&
                isEqual(node1.right, node2.right)&&
                node1.val == node2.val;
    }
}
