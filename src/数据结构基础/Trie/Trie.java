package 数据结构基础.Trie;

import java.util.HashMap;

public class Trie<V> {
    private int size;
    private Node<V> root;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;
        root = null;
    }

    public V get(String key) {
        Node<V> node = node(key);
        return node == null ? null : node.value;
    }

    public boolean contains(String key) {
        return node(key) != null;
    }

    public V add(String key, V value) {
        keyCheck(key);
        
        if (root == null){
            root = new Node<V>(null);
        }

        Node<V> node = root;
        int len = key.length();
        for (int i = 0; i < len; i++){
            char c = key.charAt(i);
            boolean emptyChildren = node.children == null;
            Node<V> childNode = emptyChildren ? null : node.children.get(c);
            if (childNode == null) {
                childNode = new Node<>(node);
                childNode.character = c;
                node.children = emptyChildren ? new HashMap<>() : node.children;
                node.children.put(c, childNode);
            }
            node = childNode;
        }
        if (node.word){
            V oldValue = node.value;
            node.value = value;
         }

        node.word = true;
        node.value = value;
        size++;
        return null;
    }

    public V remove(String key) {
        return null;
    }

    public boolean startsWith(String prefix) {
        return node(prefix) != null;
    }

    private Node<V> node(String key) {
        keyCheck(key);
        Node<V> node = root;
        int len = key.length();
        for (int i = 0;i < len; i++){
            char c = key.charAt(i);
            node = node.getChildren().get(c);
            if (node == null) return  null;
        }
        return node.word ? node : null;
    }

    private void keyCheck(String key) {
        if (key == null || key.length() == 0) {
            throw new IllegalArgumentException("key must not be empty");
        }
    }

    private static class Node<V> {
        public char character;
        HashMap<Character,Node<V>> children;
        V value;
        boolean word;
        Node<V> parent;

        public Node(Node<V> parent) {
            this.parent = parent;
        }

        public HashMap<Character, Node<V>> getChildren() {
            return children == null ? (children=new HashMap<>()): children;
        }
    }
}
