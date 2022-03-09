package com.数据结构1.Heap;

import java.util.PriorityQueue;

public class L_1845_座位预约管理系统 {
    class SeatManager {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        public SeatManager(int n) {
            for (int i = 1; i <= n;i++){
                priorityQueue.add(i);
            }
        }

        public int reserve() {
            return priorityQueue.poll();
        }

        public void unreserve(int seatNumber) {
            priorityQueue.offer(seatNumber);
        }
    }
}
