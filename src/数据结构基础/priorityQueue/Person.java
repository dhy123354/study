package 数据结构基础.priorityQueue;

public class Person implements Comparable<Person> {
    private  String name;
    private  int bonebreak;

    public Person(String name,int bonebreak) {
        this.bonebreak = bonebreak;
        this.name = name;
    }

    @Override
    public int compareTo(Person person) {
        return this.bonebreak -  person.bonebreak;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", boneBreak=" + bonebreak + "]";
    }
}
