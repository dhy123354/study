package com.数据结构1.Queue;

import java.util.LinkedList;
import java.util.Queue;
//自己作业 用交换方法再写一个
public class L_225_用队列实现栈 {
    private Queue<Integer> outQueue;
    private Queue<Integer> inQueue;

    /** Initialize your data structure here. */
    public L_225_用队列实现栈 () {
        outQueue = new LinkedList<>();
        inQueue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        outQueue.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (!outQueue.isEmpty()){
            while (!outQueue.isEmpty()&&outQueue.size()!=1){
                inQueue.offer(outQueue.peek());
                outQueue.poll();
            }
            int tmp = outQueue.peek();
            outQueue.poll();
            return tmp;
        }else {
            return outQueue.poll();
        }
    }

    /** Get the top element. */
    public int top() {
        if (!outQueue.isEmpty()){
            while (!outQueue.isEmpty()&&outQueue.size()!=1){
                inQueue.offer(outQueue.peek());;
            }
            int tmp = outQueue.peek();
            return tmp;
        }else {
            return outQueue.peek();
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return outQueue.isEmpty()&&inQueue.isEmpty();
    }
}
