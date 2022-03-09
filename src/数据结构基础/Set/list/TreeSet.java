package 数据结构基础.Set.list;

import 数据结构基础.Set.Set;
import 数据结构基础.Set.tree.BinaryTree;
import 数据结构基础.Set.tree.RBTree;

public class TreeSet<E> implements Set<E> {
    private RBTree<E> tree =new RBTree<E>();


    @Override
    public int size() {
        return tree.size();
    }

    @Override
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    @Override
    public void clear() {
        tree.clear();
    }

    @Override
    public boolean contains(E element) {
        return tree.contains(element);
    }

    @Override
    public void add(E element) {
        tree.add(element);
    }

    @Override
    public void remove(E element) {
        tree.remove(element);
    }

    @Override
    public void traversal(Visitor<E> visitor) {
        tree.inorder(new BinaryTree.Visitor<E>() {
            @Override
            public boolean visit(E element) {
                return visitor.visit(element);
            }
        });
    }
}
