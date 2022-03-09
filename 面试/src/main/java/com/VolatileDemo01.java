package com;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class VolatileDemo01 {
    public static void main(String[] args) {
        atomicByVolatile();
    }

    public static void atomicByVolatile(){
        MyDate myDate = new MyDate();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                myDate.addSelf();
                myDate.atomicInteger();
            },"Thread " + i).start();
        }
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"\t finally num value is "+myDate.num);
        System.out.println(Thread.currentThread().getName()+"\t finally atomicnum value is "+myDate.atomicInteger);
    }
}

class MyDate{
    volatile int num = 0;

    public void addToSixty(){
        this.num = 60;
    }

    public void addSelf(){
        num++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void atomicInteger(){
        atomicInteger.getAndIncrement();
    }
}
