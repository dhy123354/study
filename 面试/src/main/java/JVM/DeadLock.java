package JVM;

public class DeadLock {
    public static void main(String[] args) {
        Object A = new Object();
        Object B = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (A) {
                System.out.println("lock A");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B) {
                    System.out.println("lock B");
                    System.out.println("操作...");
                }
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            synchronized (B) {
                System.out.println("lock B");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (A) {
                    System.out.println("lock A");
                    System.out.println("操作...");
                }
            }
        }, "t2");
        t1.start();
        t2.start();
    }
}
