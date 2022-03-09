package JVM.哲学家;

import java.util.Date;

public class Philosopher extends Thread{
    Chopstick left;
    Chopstick right;

    public Philosopher(String name, Chopstick left, Chopstick right) {
        super(name);
        this.left = left;
        this.right = right;
    }

    private void eat() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + new Date() + ": eating..");
        Thread.sleep(1000);
    }

    @Override
    public void run() {
        while (true){
            //获得左筷子
            synchronized (left){
                //获得右筷子
                synchronized (right){
                    try {
                        //吃饭
                        eat();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //放下右手筷子
            }
            //放下左筷子
        }
    }

    public static void main(String[] args) {
        Chopstick c1 = new Chopstick("1");
        Chopstick c2 = new Chopstick("2");
        Chopstick c3 = new Chopstick("3");
        Chopstick c4 = new Chopstick("4");
        Chopstick c5 = new Chopstick("5");
        new Philosopher("苏格拉底", c1, c2).start();
        new Philosopher("柏拉图", c2, c3).start();
        new Philosopher("亚里士多德", c3, c4).start();
        new Philosopher("赫拉克利特", c4, c5).start();
        new Philosopher("阿基米德", c1, c5).start();

    }
}
