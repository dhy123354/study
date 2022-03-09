package 序列化;

import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Demo01{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
