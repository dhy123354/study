package 数据结构基础.Queue;

import 数据结构基础.Queue.list.LinkedList;
import 数据结构基础.Queue.list.List;

public class Queue<E> {
    private List<E> list  = new LinkedList<E>();

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void enQueue(E element){
        list.add(element);
    }

    public E deQueue(){
        return list.remove(0);
    }

    public E front(){
        return list.get(0);
    }
}
