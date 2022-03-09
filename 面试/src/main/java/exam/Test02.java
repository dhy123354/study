package exam;

public class Test02 implements Runnable{
    @Override
    public void run() {
        //run(）方法重写
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码。。。。" + i);
        }
    }

    public static void main(String[] args) {
        //创建runnable接口的实现类对象
        Test02 testThread = new Test02();

        //创建线程对象，通过线程对象来开启我们的线程，代理
        //Thread thread = new Thread(testThread);
        //thread.start();
        new Thread(testThread).start();

        for (int i = 0; i < 20; i++) {
            System.out.println("我在学习多线程。。。。" + i);
        }
    }


}
