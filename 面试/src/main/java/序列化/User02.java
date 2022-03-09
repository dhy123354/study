package 序列化;

import java.io.*;

public class User02 implements Externalizable {

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

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeObject(age);
    }
    public void readExternal(ObjectInput in) throws IOException,
            ClassNotFoundException {
        name = (String) in.readObject();
        age = (int) in.readObject();
    }
    /*
    * throw和throws的区别是什么：
    *   Java中的异常处理除了包括捕获异常和处理异常之外，还包括声明异常和抛出异常,
    *   可以通过throws关键字再方法上声明该方法要抛出异常，或者再方法内部通过throw抛出异常对象、
    *   throws关键字和throw关键字使用上的几点区别如下：
    *       throw关键字用在方法内部，只能抛出一种异常，用来抛出方法或代码块中的异常，受查异常，
    *       和非受查异常都可以抛出
    *       throws关键字用在方法上，可以抛出多个异常，用来标识该方法可能抛出的异常列表。一个方法
    *       用throws标识了可能抛出的异常列表，调用该方法的方法中必须包含可处理异常的代码，否则也要
    *       在方法签名中用throws关键字声明相应的异常
    *
    * */
}
