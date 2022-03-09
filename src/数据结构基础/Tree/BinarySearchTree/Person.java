package 数据结构基础.Tree.BinarySearchTree;
import java.lang.Comparable;
public class Person implements Comparable<Person> {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person o) {
        return age-o.age;
    }
}
