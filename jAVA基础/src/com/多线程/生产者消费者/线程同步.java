package com.多线程.生产者消费者;

public class 线程同步 {
    public static final int NA = 100;
    public static final int INT =1000;
    public static final int MAX =1000;
    public static final int DE =10;

    public static void main(String[] args) {
        Bank bank = new Bank(NA,INT);
        for (int i = 0; i < NA; i++) {
            int fromAccount = i;
            Runnable r = ()->{
                try {
                    while (true){
                        int toA = (int) (bank.size() * Math.random());
                        double amount = MAX +Math.random();
                        bank.transfer(fromAccount,toA,amount);
                        Thread.sleep((int) (DE * Math.random()));
                    }
                }catch (InterruptedException e){

                }
            };
            Thread thread = new Thread(r);
            thread.start();
        }
    }
}
