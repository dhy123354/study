package com.剑指offer;

import java.util.Stack;

public class L_30 {
    class MinStack {
        Stack<Integer> stack1 = null;
        Stack<Integer> stack2 = null;
        /** initialize your data structure here. */
        public MinStack() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.add(x);
            if (stack2.isEmpty() || stack2.peek() >= x)
                stack2.add(x);
        }

        public void pop() {
            if (!stack2.isEmpty() && stack1.pop().equals(stack2.peek()))
                stack2.pop();
        }

        public int top() {
            return stack1.peek();
        }

        public int min() {
            return stack2.peek();
        }
    }
}
