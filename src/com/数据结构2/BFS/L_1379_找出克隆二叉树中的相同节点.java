package com.数据结构2.BFS;

import com.sun.istack.internal.localization.NullLocalizable;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class L_1379_找出克隆二叉树中的相同节点 {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }

    }

//    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
//        Deque<TreeNode> stack1 = new LinkedList<>();
//        Deque<TreeNode> stack2 = new LinkedList<>();
//        stack1.push(original);
//        stack2.push(cloned);
//        TreeNode node1 = new TreeNode();
//        TreeNode node2 = new TreeNode();
//
//
//        while (!stack1.isEmpty()){
//            node1 = stack1.pop();
//            node2 = stack2.pop();
//            if (target == node1) break;
//
//            if (node1.right != null){
//                stack1.push(node1.right);
//                stack2.push(node2.right);
//            }
//
//            if (node1.left != null){
//                stack1.push(node1.left);
//                stack2.push(node2.left);
//            }
//        }
//        return node2;
//    }

    //文件流.递归
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) return null;

        if (original == target) return cloned;

        TreeNode res = getTargetCopy(original.left,cloned.left,target);
        return  res == null ? getTargetCopy(original.right,cloned.right,target) : res;
    }


}