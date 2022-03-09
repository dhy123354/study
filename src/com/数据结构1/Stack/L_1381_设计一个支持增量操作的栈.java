package com.数据结构1.Stack;

public class L_1381_设计一个支持增量操作的栈 {
    class CustomStack {
        private int[] stack;;
        int top;
        public CustomStack(int maxSize) {
            stack = new int[maxSize];
            top = -1;
        }

        public void push(int x) {
            if (top != stack.length - 1){
                ++top;
                stack[top] = x;
            }
        }

        public int pop() {
            if (top == -1){
                return -1;
            }
            --top;
            return stack[top + 1];
        }

        public void increment(int k, int val) {
            int limit = Math.min(k, top + 1);
            for (int i = 0; i < limit; i++) {
                stack[i] += val;
            }
        }
    }
}
