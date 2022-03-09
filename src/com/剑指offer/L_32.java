package com.剑指offer;

import java.util.*;

public class L_32 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[]{};
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);

        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String[] temp=in.nextLine().split(",");
            int sum=0;
            for(String s:temp)
                sum+=Integer.valueOf(s);
            System.out.println(sum);
        }
    }

}
