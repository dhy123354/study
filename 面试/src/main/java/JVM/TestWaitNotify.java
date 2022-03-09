package JVM;

import java.util.Date;

public class TestWaitNotify {

    final static Object ocj = new Object();

    public static void main(String[] args) throws InterruptedException {
        new  Thread(() ->{
            synchronized (ocj){
                System.out.println(new Date() + "执行了");
                try {
                    ocj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new Date() + "其他代码");
            }
        },"t1").start();

        new  Thread(() ->{
            synchronized (ocj){
                System.out.println(new Date() + "执行了");
                try {
                    ocj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new Date() + "其他代码");
            }
        },"t2").start();

        Thread.sleep(500);
        System.out.println("唤醒obj上的其他线程");
        synchronized (ocj){
            ocj.notifyAll();
        }
    }

}
