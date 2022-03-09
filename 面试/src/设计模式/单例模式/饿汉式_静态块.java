package 单例模式;

public class 饿汉式_静态块 {
    public static void main(String[] args) {
        Singleton02 singleton02 = Singleton02.getInstance();
        Singleton02 singleton03 = Singleton02.getInstance();
        System.out.println(singleton02.hashCode());
        System.out.println(singleton03.hashCode());
    }
}
class Singleton02{
    //构造器私有化，外部能new
    private Singleton02(){};

    private static Singleton02 instance;

    static {
        instance = new Singleton02();
    }

    public static Singleton02 getInstance() {
        return instance;
    }
}
/*
 优缺点说明：
        1) 这种方式和上面的方式其实类似，只不过将类实例化的过程放在了静态代码块中，也是在类装载的时候，就执
        行静态代码块中的代码，初始化类的实例。优缺点和上面是一样的。
        2) 结论：这种单例模式可用，但是可能造成内存浪费
*/
