package com.数据结构1.Heap;

import java.util.PriorityQueue;

public class L_1046_最后一块石头的重量 {
    public int lastStoneWeight(int[] stones) {
        if (stones == null) return 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>((i1,i2) -> i2 - i1);
        for (int i = 0; i < stones.length; i++){
            heap.add(stones[i]);
        }

        while (heap.size()>=2){
            int x = heap.poll();
            int y = heap.poll();

            if ( x > y){
                heap.add(x - y);
            }
        }
        return heap.size() == 1 ? heap.peek() : 0;
    }
}
