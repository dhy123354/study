package JVM;

import java.util.Date;

public class BigRoomTest {

    private final Object studyRoom = new Object();
    private final Object bedRoom = new Object();

    public void sleep() throws InterruptedException {
        synchronized (bedRoom){
            System.out.println(new Date() + "sleeping 2 小时");
            Thread.sleep(2000);
        }
    }

    public void study() throws InterruptedException {
        synchronized (studyRoom){
            System.out.println(new Date() + "study 1 小时");
            Thread.sleep(1000);
        }
    }

    public static void main(String[] args) {
        BigRoomTest bigRoomTest = new BigRoomTest();
        new  Thread(() ->{
            try {
                bigRoomTest.study();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"小南").start();

        new Thread(() -> {
            try {
                bigRoomTest.sleep();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"小女").start();
    }
}
