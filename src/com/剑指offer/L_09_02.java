package com.剑指offer;


import java.util.LinkedList;

public class L_09_02 {

    class MyStack {
        LinkedList<Integer> queue1 ;
        LinkedList<Integer> queue2 ;

        /** Initialize your data structure here. */
        public MyStack() {
            queue1=new LinkedList<>();
            queue2=new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue1.add(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            int temp=-1;
            while(!queue1.isEmpty()){
                temp=queue1.pop();
                if(queue1.isEmpty()) break;
                queue2.add(temp);
            }
            while(!queue2.isEmpty()){
                queue1.add(queue2.pop());
            }
            return temp;
        }

        /** Get the top element. */
        public int top() {
            int temp=-1;
            while(!queue1.isEmpty()){
                temp=queue1.pop();
                queue2.add(temp);
            }
            while(!queue2.isEmpty()){
                queue1.add(queue2.pop());
            }
            return temp;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            if(queue1.isEmpty()&&queue2.isEmpty()) return true;
            return false;

        }
    }
}
