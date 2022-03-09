package 数据结构基础.Tree.BinarySearchTree;

import 数据结构基础.Tree.BinarySearchTree.printer.BinaryTreeInfo;

import java.util.*;

public class BinarySearchTree<E> implements BinaryTreeInfo {
    private int size;
    private Node<E> root;
    private Comparator<E> comparator;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public void add(E element) {
        elementNotNullCheck(element);

        // 添加第一个节点
        if (root == null) {
            root = new BinarySearchTree.Node<>(element, null);
            size++;
            return;
        }

        // 添加的不是第一个节点
        // 找到父节点
        BinarySearchTree.Node<E> parent = root;
        BinarySearchTree.Node<E> node = root;
        int cmp = 0;
        do {
            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else { // 相等
                node.element = element;
                return;
            }
        } while (node != null);

        // 看看插入到父节点的哪个位置
        BinarySearchTree.Node<E> newNode = new BinarySearchTree.Node<>(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;
    }

    public void remove(E element) {
        remove(node(element));
    }

    public boolean contains(E element) {
        return node(element) != null;
    }

    private void remove(Node<E> node){
        if (node == null) return;
        size--;

        if (node.hasTwoChildren()){
            Node<E> s = successor(node);

            node.element = s.element;

            node = s;
        }

        Node<E> replacement = node.left != null ? node.left : node.right;

        if (replacement != null) { // node是度为1的节点
            // 更改parent
            replacement.parent = node.parent;
            // 更改parent的left、right的指向
            if (node.parent == null) { // node是度为1的节点并且是根节点
                root = replacement;
            } else if (node == node.parent.left) {
                node.parent.left = replacement;
            } else { // node == node.parent.right
                node.parent.right = replacement;
            }
        } else if (node.parent == null) { // node是叶子节点并且是根节点
            root = null;
        } else { // node是叶子节点，但不是根节点
            if (node == node.parent.left) {
                node.parent.left = null;
            } else { // node == node.parent.right
                node.parent.right = null;
            }
        }
    }

    private Node<E> node(E element) {
        BinarySearchTree.Node<E> node = root;
        while (node != null) {
            int cmp = compare(element, node.element);
            if (cmp == 0) return  node;
            if (cmp > 0) {
                node = node.right;
            } else { // cmp < 0
                node = node.left;
            }
        }
        return null;
    }

    private int  compare(E e1,E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>) e1).compareTo(e2);
    }

//    //前序遍历
    public void preorderTraversal() {
		preorderTraversal(root);
	}

	private void preorderTraversal(Node<E> node) {
		if (node == null) return;

		System.out.println(node.element);
		preorderTraversal(node.left);
		preorderTraversal(node.right);
	}

    public void D_preorderTraversal(){
        if (root == null) return;
        Stack<Node<E>> stack = new Stack<>();
        stack.add(root);
        while (stack.isEmpty() == false){
            Node<E> node = stack.pop();
            System.out.println(node.element+" ");

            if (node.right != null){
                stack.add(node.right);
            }
            if (node.left != null){
                stack.add(node.left);
            }
        }
    }

    //中序遍历
    public void inorderTraversal() {
        inorderTraversal(root);
    }

    private void inorderTraversal(Node<E> node) {
        if (node == null) return;

        inorderTraversal(node.left);
        System.out.println(node.element);
        inorderTraversal(node.right);
    }

    public void D_inorderTraversal(){
        if(root == null) return;
        Stack<Node<E>> stack = new Stack<>();
        Node<E> node = root;
        stack.add(node);
        while (!stack.isEmpty()){
            while(node != null){
                stack.push(node);
                //当前节点等于它的左节点
                node = node.left;
            }
            //栈不为空的情况下再遍历
            if(!stack.isEmpty()){
                node = stack.pop();
                System.out.print(node.element+" ");
                //右节点
                node = node.right;
            }
        }
    }
    //后序便利
    public void postorderTraversal() {
        postorderTraversal(root);
    }

    private void postorderTraversal(Node<E> node) {
        if (node == null) return;

        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.println(node.element);
    }

    public void D_postorderTraversal(){
        if(root == null) return;
        Stack<Node<E>> s1 = new Stack<>();
        Stack<Node<E>> s2 = new Stack<>();
        Node<E> node = root;
        s1.add(node);
        while(!s1.isEmpty()){
            node = s1.pop();
            s2.push(node);
            if(node.left != null){
                s1.push(node.left);
            }
            if(node.right != null){
                s1.push(node.right);
            }
        }
        while(!s2.isEmpty()){
            System.out.print(s2.pop().element + " ");
        }
    }
//    public void LevelOrderTraversal(){
//        LevelOrderTraversal(root);
//    }
//
//    private void LevelOrderTraversal(Node<E> root) {
//        if (root == null) return;
//
//        数据结构基础.Queue<Node<E>> queue = new LinkedList<>();
//        queue.offer(root);
//
//        while (!queue.isEmpty()){
//            Node<E> node = queue.poll();
//            System.out.println(node.element);
//
//            if (node.left != null){
//                queue.offer(node.left);
//            }
//
//            if (node.right != null){
//                queue.offer(node.right);
//            }
//        }
//    }

//    public void LevelOrderTraversal(){
//        LevelOrderTraversal(root);
//    }

    private Node<E> predecessor(Node<E> node){
        if (node == null) return null;

        Node<E> p =node.left;
        if (p != null){
            while (p.right != null){
                p = p.right;
            }
            return p;
        }

        while (node.parent != null && node == node.parent.left){
            node = node.parent;
        }

        return node.parent;
    }

    private Node<E> successor(Node<E> node){
        if (node == null) return null;

        Node<E> p = node.right;
        if (p != null){
            while (p.left != null){
                p = p.left;
            }
            return p;
        }

        while (node.parent != null && node == node.parent.right){
            node = node.parent;
        }

        return node.parent;
    }

    public void levelOrder(BinarySearchTree.Visitor<E> visitor) {
        if (root == null || visitor == null) return;

        Queue<BinarySearchTree.Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            BinarySearchTree.Node<E> node = queue.poll();
            if (visitor.visit(node.element)) return;

            if (node.left != null) {
            queue.offer(node.left);
             }

            if (node.right != null) {
            queue.offer(node.right);
            }
        }
    }


    public static abstract class Visitor<E> {
        boolean stop;
        /**
         * @return 如果返回true，就代表停止遍历
         */
        public abstract boolean visit(E element);
    }

    public int height1() {
        if (root == null) return 0;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        int height = 0;
        int levelsize = 1;

        while (!queue.isEmpty()){
            Node<E> node = queue.poll();
            levelsize--;

            if (node.left != null){
                queue.offer(node.left);
            }

            if (node.right != null){
                queue.offer(node.right);
            }

            if (levelsize == 0){
                levelsize = queue.size();
                height++;
            }
        }
        return height;
    }

    public int height() {
        return height(root);
    }

    private int height(Node<E> node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root, sb, "");
        return sb.toString();
    }

    private void toString(BinarySearchTree.Node<E> node, StringBuilder sb, String prefix) {
        if (node == null) return;

        toString(node.left, sb, prefix + "L---");
        sb.append(prefix).append(node.element).append("\n");
        toString(node.right, sb, prefix + "R---");
    }

    public boolean isComplete(){
        if (root == null) return false;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        boolean leaf = false;
        while (!queue.isEmpty()){
            Node<E> node = queue.poll();

            if (leaf && !node.isLeaf()) return false;

            if (node.left!=null){
                queue.offer(node.left);
            }else if(node.right != null) {
                return false;
            }

            if (node.right != null){
                queue.offer(node.right);
            }else {
                leaf = true;
            }
        }

        return true;
    }
//    public boolean isComplete(){
//        if (root == null) return false;
//
//        数据结构基础.Queue<Node<E>> queue = new LinkedList<>();
//        queue.offer(root);
//
//        boolean leaf = false;
//        while (!queue.isEmpty()){
//            Node<E> node = queue.poll();
//
//            if (leaf && !node.isLeaf())return false;
//            if (node.hasTwoChildren()){
//                queue.offer(node.left);
//                queue.offer(node.right);
//            }else if (node.left == null && node.right != null){
//                return false;
//            }
//            else {
//                leaf  = true;
//                if (node.left != null) {
//                    queue.offer(node.left);
//                }
//            }
//        }
//
//        return true;
//    }
    private static class Node<E> {
        E element;
        BinarySearchTree.Node<E> left;
        BinarySearchTree.Node<E> right;
        BinarySearchTree.Node<E> parent;
        public Node(E element, BinarySearchTree.Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public boolean hasTwoChildren() {
            return left != null && right != null;
        }
    }

    private void elementNotNullCheck(E element){
        if (element == null){
            throw new IllegalArgumentException("element must mull");
        }
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>)node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>)node).right;
    }

    @Override
    public Object string(Object node) {
        BinarySearchTree.Node<E> myNode = (BinarySearchTree.Node<E>)node;
        String parentString = "null";
        if (myNode.parent != null) {
            parentString = myNode.parent.element.toString();
        }
        return myNode.element + "_p(" + parentString + ")";
    }

}
