package com.剑指offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class L_09 {
    class CQueue {
        Stack<Integer> stack2 = null;
        Stack<Integer> stack1 = null;

        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.add(value);
        }

        public int deleteHead() {
            if (stack2.isEmpty()){
                if (stack1.isEmpty()) return -1;
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            }
            return stack2.pop();
        }
    }
    static class CStack{
        Queue<Integer> queue1 = null;
        Queue<Integer> queue2 = null;

        public CStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        public void add(int value){
            while (!queue1.isEmpty()){
                queue2.add(queue1.poll());
            }
            queue1.add(value);
            while (!queue2.isEmpty()){
                queue1.add(queue2.poll());
            }
            if (queue1.isEmpty()) {
                queue1.add(value);
                return;
            };
        }

        public int pop() {
            Integer poll = queue1.poll();
            return poll == null ? -1 :poll ;
        }

        /** Get the top element. */
        public int top() {
            return queue1.peek() == null ? -1 :queue1.peek();
        }
    }

    public static void main(String[] args) {
        System.out.println("==============");
        CStack cStack = new CStack();
        cStack.add(1);
        cStack.add(2);
        cStack.add(3);
        cStack.add(14);
        System.out.println(cStack.pop());
        System.out.println(cStack.pop());
    }
}
