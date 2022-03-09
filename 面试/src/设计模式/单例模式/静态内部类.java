package 单例模式;

public class 静态内部类 {
    public static void main(String[] args) {
        System.out.println("使用静态内部类完成单例模式");
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                Singleton05 singleton05 = Singleton05.getInstance();
            },String.valueOf(i)).start();
        }
    }
}
class Singleton05{
    private static volatile  Singleton05 instance;

    private Singleton05(){System.out.println(Thread.currentThread().getName() + "\t 构造方法");}

    private static class SingletonInstance{
        private static final Singleton05 INSTANCE = new Singleton05();
    }

    public static synchronized Singleton05 getInstance(){
        return SingletonInstance.INSTANCE;
    }
}
