package 单例模式;

public class 单例模式 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                User1.getZs();
            },String.valueOf(i)).start();
        }

    }
}

//饿汉式
class User1{
    User1(){
        System.out.println(Thread.currentThread().getName() + "\t 构造方法");
    }
    public static User1 zs = new User1();
    public static User1 getZs(){
        return zs;
    }
}
//懒汉式
class User2{
    User2(){

    }
    public static User2 ls = null;
    public synchronized static User2 getLs(){
        if (ls == null){
            ls = new User2();
        }
        return ls;
    }
}
//双重加锁机制
class User3{
    private User3(){

    }
    private static User3 ww = null;
    private static User3 getWw(){
        if (ww == null){
            synchronized (User3.class){
                if (ww == null){
                    ww = new User3();
                }
            }
        }
        return ww;
    }
}
