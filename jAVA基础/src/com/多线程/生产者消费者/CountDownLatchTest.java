package com.多线程.生产者消费者;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args) {
        final CountDownLatch c = new CountDownLatch(3);//总数3
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    System.out.println("开始等");
                    c.await();//阻塞，等待countDown，当countDown到0就执行后面的完事了
                    System.out.println("完事");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i=3;i>0;i--){
                    c.countDown();//减1
                }
            }

        });
        t1.start();
        t2.start();
    }
}
