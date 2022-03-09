package com.数据结构1.Tree;

import java.util.*;

public class L_559_N叉树的最大深度 {
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

    //文件流.递归

    public int maxDepth(Node root){
        if (root == null) return 0;
        int height = 0;
        for (int i =0;i<root.children.size();i++){
            height = Math.max(height,maxDepth(root.children.get(i)));
        }
        return height;
    }

    //迭代
    public int maxDepth1(Node root) {
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int height = 0;
        int levelSize = 1;

        while (!queue.isEmpty()){
            Node node = queue.poll();
            levelSize--;

            for (int i = 0;i<node.children.size();i++){
                queue.offer(node.children.get(i));
            }

            if (levelSize == 0){
                levelSize = queue.size();
                height++;
            }
        }
        return height;
    }
}
