package 面试;


public class Main01  {
    public static void main(String[] args) {
        SyncWaitNotify syncWaitNotify = new SyncWaitNotify(1,5);
        new  Thread(() ->{
            syncWaitNotify.print(1,2,"A");
        },"t1").start();
        new  Thread(() ->{
            syncWaitNotify.print(2,3,"B");
        },"t2").start();
        new  Thread(() ->{
            syncWaitNotify.print(3,1,"C");
        },"t3").start();
    }
}

class SyncWaitNotify {
    private int flag;
    private int loopNumber;

    public SyncWaitNotify(int flag,int loopNumber){
        this.flag = flag;
        this.loopNumber = loopNumber;
    }

    public void print(int waitFlag,int nextFlag,String str){
        for (int i = 0; i < loopNumber; i++) {
            synchronized (this){
                while (this.flag != waitFlag){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(str);
                flag = nextFlag;
                this.notifyAll();
            }
        }
    }
}

