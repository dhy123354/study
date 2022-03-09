import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo01 {

    public static void main(String[] args) throws InterruptedException {
        sixCountry();
    }

    public static void sixCountry() throws InterruptedException{
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new  Thread(() ->{
                System.out.println(Thread.currentThread().getName() + "\t" + "国，灭亡");
                countDownLatch.countDown();
            },CountryEnum.forEach(i).getName()).start();
        }
        countDownLatch.await();
        System.out.println("秦统一");
    }

}
