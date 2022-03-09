package com.多线程.生产者消费者;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 锁 {
        private final double[] accounts;
        private Lock bankLock;
        private Condition suff;

    public 锁(double inital, int n) {
        accounts = new double[n];
        Arrays.fill(accounts,inital);
        bankLock = new ReentrantLock();
        suff = bankLock.newCondition();
    }

    public void transfer(int from ,int to, double amount){
        bankLock.lock();
        try {
            while (accounts[from] <amount)
                suff.await();
            if (accounts[from] < amount) return;
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf("Total Balance:%10.2f%n", getTotalBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bankLock.unlock();
        }
    }

    public double getTotalBalance(){
        bankLock.lock();
        try {
            double sum = 0;
            for (double a : accounts) {
                sum += a;
            }
            return sum;
        }finally {
            bankLock.unlock();
        }
    }

    public int size(){
        return accounts.length;
    }
}
