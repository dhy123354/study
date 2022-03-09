package 数据结构基础.Set;

public class Main {
    static void test1() {

        Set<Integer> listSet = new ListSet<Integer>();
        listSet.add(10);
        listSet.add(11);
        listSet.add(11);
        listSet.add(12);
        listSet.add(10);

        Set<Integer> TreeSet = new ListSet<Integer>();
        TreeSet.add(10);
        TreeSet.add(11);
        TreeSet.add(11);
        TreeSet.add(12);
        TreeSet.add(10);

        TreeSet.traversal(new Set.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.println(element);
                return false;
            }
        });
    }
    public static void main(String[] args) {
        test1();
    }
}
