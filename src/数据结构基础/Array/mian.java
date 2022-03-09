package 数据结构基础.Array;


public class mian {
    public static void main(String[] args) {
//        ArrayList list = new ArrayList(6);
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.add(6);
//        list.remove(2);
//        System.out.println(list);
//        list.add(2,3);
//        System.out.println(list.size());
//        System.out.println(list.isEmpty());
//        System.out.println(list.get(0));
//        System.out.println(list);
//       list.add(list.size(),8);
//        System.out.println(list);
//        System.out.println(list.set(2,5));
//        System.out.println(list.toString());
//
//        for (int i =0;i<30;i++){
//            list.add(i);
//        }
//        System.out.println(list);
//
//        ArrayList<Integer> list1 = new ArrayList<>();
//        for (int i = 0;i< 5;i++){
//            list1.add(i);
//        }
//        System.out.println(list1);
//
//        ArrayList<Person> list2  =new ArrayList<>();
//        list2.add(new Person(10,"123"));
//        list2.add(new Person(10,"123"));
//        list2.add(new Person(10,"123"));
//        list2.add(new Person(10,"123"));
//        System.out.println(list2);
//        //list2.clear();
//        //System.gc();

//        list2.remove(2);
//        System.out.println(list2);

        ArrayList2 list7 = new ArrayList2(9);
        for (int i = 0 ;i < 50 ;i++){
            list7.add(i);
        }
        for (int i = 0 ;i < 40 ;i++){
            list7.remove(4);
        }
        System.out.println(list7);
    }


}
