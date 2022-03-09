package com.多线程.生产者消费者;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
    static class NumberWrapper{
        public int value = 1;
    }

    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();

        final Condition reachThreeC = lock.newCondition();
        final Condition reachTSixC = lock.newCondition();

        final NumberWrapper num = new NumberWrapper();

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println("ThreadA获得lock");
                try {
                    System.out.println("ThreadA strat write");
                    while (num.value <= 3){
                        System.out.println(num.value);
                        num.value++;
                    }
                    reachThreeC.signal();
                }finally {
                    lock.unlock();
                    System.out.println("ThreadA释放lock");
                }
                lock.lock();
                try {
                    System.out.println("TreadA获得lock");
                    reachTSixC.await();
                    System.out.println("threadA strat wirte");

                    while (num.value <= 9){
                        System.out.println(num.value);
                        num.value++;
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    lock.lock();
                    System.out.println();
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println("ThreadB获得lock");
                    Thread.sleep(5000);//是await方法释放了锁
                    while (num.value <= 3) {
                        //等待3输出完毕的信号
                        reachThreeC.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                    System.out.println("ThreadB释放lock");
                }
                try {
                    lock.lock();
                    System.out.println("ThreadB获得lock");
                    //已经收到信号，开始输出4，5，6
                    System.out.println("threadB start write");
                    while (num.value <= 6) {
                        System.out.println(num.value);
                        num.value++;
                    }
                    //4，5，6输出完毕，告诉A线程6输出完了
                    reachTSixC.signal();
                } finally {
                    lock.unlock();
                    System.out.println("ThreadB释放lock");
                }
            }
        });
        threadB.start();
        threadA.start();
    }
}
