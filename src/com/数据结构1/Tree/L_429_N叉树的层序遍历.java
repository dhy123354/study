package com.数据结构1.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L_429_N叉树的层序遍历 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            List<Integer> list1 = new ArrayList<>();
            int len = queue.size();
            for (int i =1 ;i < len; ++i){
                Node node = queue.poll();
                list1.add(node.val);
//                List<Node> list2 = node.children;
//                for (Node no : list2){
//                    queue.offer(no);
//                }

            }
            list.add(list1);
        }
        return list;
    }
}
