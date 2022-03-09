package 数据结构基础.priorityQueue;

import 数据结构基础.priorityQueue.heap.BinaryHeap;

import java.util.Comparator;

public class PriorityQueue<E> {
    private BinaryHeap<E> heap ;

    public PriorityQueue(Comparator<E> Comparator){
        heap = new BinaryHeap<>(Comparator);
    }

    public PriorityQueue(){
        this(null);
    }

    public int size(){
        return heap.size();
    }

    public boolean isEmpty(){
        return heap.isEmpty();
    }

    public void enQueue(E element){
        heap.add(element);
    }

    public E deQueue(){
        return heap.remove();
    }

    public E front(){
        return heap.get();
    }
}
