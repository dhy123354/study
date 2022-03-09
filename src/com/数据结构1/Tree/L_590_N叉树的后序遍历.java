package com.数据结构1.Tree;

import java.util.ArrayList;
import java.util.List;

public class L_590_N叉树的后序遍历 {
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
    public void postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        postorder(root);
    }
    private void postorder(Node root,List<Integer> res) {
        if (root == null) return;
        for(int x = 0 ; x < root.children.size() ; x ++){
            postorder(root.children.get(x),res);
        }
        res.add(root.val);

    }
}
