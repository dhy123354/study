package JVM.同步模式之顺序控制;

import java.util.concurrent.locks.LockSupport;

public class ParkUnpark {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.park();
            System.out.println("1");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("2");
            //给线程 t1 发送【许可】（多次连续调用 unpark 只会发放一个许可）
            LockSupport.unpark(t1);
        });

        t1.start();
        t2.start();
    }

}
