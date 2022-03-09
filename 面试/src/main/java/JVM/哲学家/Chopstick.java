package JVM.哲学家;

public class Chopstick {

    String name;

    public Chopstick(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Chopstick{" +
                "name='" + name + '\'' +
                '}';
    }
}
