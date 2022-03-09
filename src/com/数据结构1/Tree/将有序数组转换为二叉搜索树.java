package com.数据结构1.Tree;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.Arrays;

public class 将有序数组转换为二叉搜索树 {

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

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) return null;
        return searchTree(nums,0,nums.length - 1);

    }

    public TreeNode searchTree(int[] nums,int begin ,int end){
        if (begin > end) return null;

        int mid =  (end + begin) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = searchTree(nums,begin,mid - 1);
        node.right = searchTree(nums,mid + 1,end);
        return node;

    }
}
