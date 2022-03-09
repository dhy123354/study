package JVM;

import java.util.Date;
import java.util.concurrent.locks.LockSupport;

public class ParkAndUnpark {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 =  new Thread(()->{
            System.out.println(new Date() + ":start...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(new Date() + ":park...");
            LockSupport.park();
            System.out.println(new Date() + ":resume...");
        },"T1");
        t1.start();
        Thread.sleep(1000);
        System.out.println(new Date() + ":unpark...");
        LockSupport.unpark(t1);
    }
}
