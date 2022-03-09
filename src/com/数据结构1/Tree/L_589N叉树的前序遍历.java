package com.数据结构1.Tree;

import java.util.ArrayList;
import java.util.List;

public class L_589N叉树的前序遍历 {
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

    private List<Integer> list = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) return list;
        list.add(root.val);
        for (int i = 0; i < root.children.size();i++ ){
            preorder(root.children.get(i));
        }
        return list;
    }
}
