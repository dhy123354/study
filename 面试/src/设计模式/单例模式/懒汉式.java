package 单例模式;

public class 懒汉式 {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                Singleton04 singleton01 = Singleton04.getInstance();
            },String.valueOf(i)).start();
        }
    }

}
//线程不安全
class Singleton03{

    private static  Singleton03 instance;

    private Singleton03(){System.out.println(Thread.currentThread().getName() + "\t 构造方法");};

    public static Singleton03 getInstance(){
        if (instance == null){
            instance = new Singleton03();
        }
        return instance;
    }
}
/**
 * 优缺店：
 *     1.起到了延迟加载的过程，但是只能在单线程下使用
 *     2.如果在多线程下，一个线程进入了if (singleton == null)判断语句块，还未来得及往下执行，另一个线程也通过
 * 了这个判断语句，这时便会产生多个实例。所以在多线程环境下不可使用这种方式
 *     3.结论：在实际开发中，不要使用这种方式
 */
//线程安全，双重检测机制
class Singleton04{
    private static volatile Singleton04 instance;

    private Singleton04(){System.out.println(Thread.currentThread().getName() + "\t 构造方法");}

    public static Singleton04 getInstance(){
        if (instance == null){
            synchronized (Singleton04.class){
                if (instance == null){
                    instance = new Singleton04();
                }
            }
        }
        return instance;
    }
}