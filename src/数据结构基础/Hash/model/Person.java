package 数据结构基础.Hash.model;

public class Person {
    private int age;
    private float height;
    private String name;

    public Person(int age, float height, String name){
        this.age = age;
        this.name =name;
        this.height =height;
    }

    @Override
    public int hashCode() {
        int hasCode = Integer.hashCode(age);
        hasCode = hasCode * 31 + Float.hashCode(height);
        hasCode = hasCode * 31 + (name != null ? name.hashCode():0);
        return hasCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != getClass()) return false;

        Person person = (Person) o;

        return person.age == age
                && person.height == height
                && person.name == name;
    }
}
