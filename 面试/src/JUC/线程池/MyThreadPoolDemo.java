package 线程池;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPoolDemo{
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();

        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> { System.out.println(Thread.currentThread().getName() + "\t 办理业务"); });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
    }


}
