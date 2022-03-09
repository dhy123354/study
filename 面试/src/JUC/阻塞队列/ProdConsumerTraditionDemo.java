package 阻塞队列;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 传统模式的生产者消费者模式
 */
public class ProdConsumerTraditionDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    shareData.deIncrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();
    }
}

class ShareData {
    private int num = 10;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws Exception {
        lock.lock();
        try {
            //判断
            while (num <= 5) {
                //等待 不生产
                condition.await();
            }
            //干活
            num++;
            System.out.println(Thread.currentThread().getName() + "\t" + num);
            //通知唤醒
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void deIncrement() throws Exception{
        lock.lock();
        try {
            while (num == 0 ){
                //等待，不消费
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName() + "\t" + num);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

}
