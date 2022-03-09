package com.多线程.生产者消费者;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private final double[] accounts;
    private Lock banklock = new ReentrantLock();

    public Bank(int n,double inital) {
        accounts = new double[n];
        Arrays.fill(accounts, inital);
    }

    public void transfer(int from ,int to, double amount){
        banklock.lock();
        try {
            if (accounts[from] < amount) return;
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf("Total Balance:%10.2f%n", getTotalBalance());
        }finally {
            banklock.unlock();
        }
    }

    public double getTotalBalance(){
        double sum = 0;
        for (double a:accounts){
            sum += a;
        }
        return sum;
    }

    public int size(){
        return accounts.length;
    }
}
