package com;

/**
 * 多线程调用共享资源
 */
class Phone{
    public synchronized void sendSms() throws Exception{
        System.out.println(Thread.currentThread().getName()+"\tsendSms");
        Thread.sleep(3000);
        sendEmail();
    }
    public synchronized void sendEmail() throws Exception{
        System.out.println(Thread.currentThread().getName()+"\tsendEmail");
    }
}

public class ReenterLockDemo {

    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()->{
            try {
                phone.sendSms();
            }catch (Exception e){
                e.printStackTrace();
            }
        },"T1").start();

        new Thread(()->{
            try {
                phone.sendEmail();
            }catch (Exception e){
                e.printStackTrace();
            }
        },"T2").start();
    }
}
