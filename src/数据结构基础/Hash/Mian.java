package 数据结构基础.Hash;

import 数据结构基础.Hash.map.HashMap;
import 数据结构基础.Hash.model.Key;
import 数据结构基础.Hash.model.Person;

public class Mian {
    public static void main(String[] args) {
        Person s1 = new Person(10,1.67f,"jack");
        Person s2 = new Person(10,1.67f,"jack");
//        System.out.println(s1.hashCode());
//        System.out.println(s2.hashCode());

//        数据结构基础.Map<Object,Object> map = new HashMap<>();
//        map.put(s1,"abc");
//        map.put("test","abc");
//        map.put(s2,"dca");

        HashMap<Object,Integer> map = new HashMap<>();
        for (int i =0; i < 19; i++){
            map.put(new Key(i),i);
        }
        System.out.println(map.get(new Key(1)));
        map.print();
    }
}
