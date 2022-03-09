package 数据结构基础.Tree.BinarySearchTree;

import 数据结构基础.Tree.BinarySearchTree.printer.BinaryTrees;

public class Mian {

//    private static class PersonComparator implements Comparator<Person> {
//        public int compare(Person e1, Person e2) {
//            return e1.getAge() - e2.getAge();
//        }
//    }
//
//    private static class PersonComparator2 implements Comparator<Person> {
//        public int compare(Person e1, Person e2) {
//            return e2.getAge() - e1.getAge();
//        }
//    }
static void test3() {
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();
    for (int i = 0; i < 15; i++) {
        bst.add((int)(Math.random() * 100));
    }

    BinaryTrees.println(bst);
 //   bst.preorderTraversal();
   // bst.inorderTraversal();
    //bst.postorderTraversal();
   // bst.LevelOrderTraversal();
//    bst.levelOrder(new BinarySearchTree.Visitor<Integer>() {
//        @Override
//        public boolean visit(Integer element) {
//            System.out.print("_"+element+"_");
//            return element == 4 ? true:false;
//        }
//    });
    System.out.println(bst.height1());

}
    static void test6() {
        Integer data[] = new Integer[]{
                7, 4, 9, 8, 2, 3, 1, 2 ,5, 6
        };

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        BinaryTrees.println(bst);
//        bst.remove(1);
//        BinaryTrees.println(bst);
//        bst.remove(4);
//        BinaryTrees.println(bst);
//        System.out.println(bst.isComplete());
        bst.D_inorderTraversal();
        bst.D_postorderTraversal();

    }
    public static void main(String[] args) {

        test6();

//        Integer data[] = new  Integer[]{
//                7,5,9,2,5,8,11
//        };
//
//        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
//        for (int i = 0;i < data.length; i++){
//            bst.add(data[i]);
//        }

//       BinaryTrees.println(bst);
//        BinarySearchTree<Person> bst1 = new BinarySearchTree<>(new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return 0;
//            }
//        });

//        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
//        for (int i = 0 ;i < bst.size() ;i++){
//            bst.add(i);
//        }

//        BinarySearchTree<Person> bst2 = new BinarySearchTree<>(new PersonComparator());
//		bst2.add(new Person(12));
//		bst2.add(new Person(15));
    }
}
