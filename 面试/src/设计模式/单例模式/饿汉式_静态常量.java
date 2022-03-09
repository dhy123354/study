package 单例模式;

public class 饿汉式_静态常量 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton == singleton2);
        System.out.println(singleton.hashCode());
        System.out.println(singleton2.hashCode());
    }
}

class Singleton{

    //构造器私有化（防止new）
    private Singleton(){};

    private final static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
}
/*
 优缺点说明：
1) 优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
2) 缺点：在类装载的时候就完成实例化，没有达到Lazy Loading(延迟加载) 的效果。如果从始至终从未使用过这个实例，则
会造成内存的浪费
3) 这种方式基于classloder 机制避免了多线程的同步问题，不过，instance 在类装载时就实例化，在单例模式中大
多数都是调用getInstance 方法，但是导致类装载的原因有很多种，因此不能确定有其他的方式（或者其他的静
态方法）导致类装载，这时候初始化instance 就没有达到lazy loading 的效果
4) 结论：这种单例模式可用，可能造成内存浪费
*/