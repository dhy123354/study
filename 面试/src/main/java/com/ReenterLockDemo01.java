package com;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Phone1 implements Runnable {
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        get();
    }

    private void get() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\tget");
            set();
        } finally {
            lock.unlock();
        }
    }

    private void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\tset");
        } finally {
            lock.unlock();
        }
    }
}

public class ReenterLockDemo01 {
    /**
     * Thread-0 get
     * Thread-0 set
     * Thread-1 get
     * Thread-1 set
     *
     * @param args
     */
    public static void main(String[] args) {
        Phone1 phone = new Phone1();
        Thread t3 = new Thread(phone,"T1");
        Thread t4 = new Thread(phone,"T2");
        t3.start();
        t4.start();

    }
}


