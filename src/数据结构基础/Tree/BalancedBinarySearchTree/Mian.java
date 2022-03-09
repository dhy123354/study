package 数据结构基础.Tree.BalancedBinarySearchTree;


import 数据结构基础.Tree.BinarySearchTree.printer.BinaryTrees;

public class Mian {
    static void test1() {
        Integer data[] = new Integer[] {
                67, 52, 92, 96, 97, 98, 99, 53, 95, 13, 63, 34, 82, 76, 54, 9, 68, 39
        };

        AVLTree<Integer> avl = new AVLTree<>();
        for (int i = 0; i < data.length; i++) {
            avl.add(data[i]);
            BinaryTrees.println(avl);
//			System.out.println("【" + data[i] + "】");
//			BinaryTrees.println(avl);
//			System.out.println("---------------------------------------");
        }

//		for (int i = 0; i < data.length; i++) {
//			avl.remove(data[i]);
//			System.out.println("【" + data[i] + "】");
//			BinaryTrees.println(avl);
//			System.out.println("---------------------------------------");
//		}
       //BinaryTrees.println(avl);
    }

    public static void main(String[] args) {
        test1();
    }
}
