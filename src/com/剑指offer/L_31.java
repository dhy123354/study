package com.剑指offer;

import java.util.Stack;

public class L_31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int len = pushed.length;
        int i = 0,j = 0;
        while (j < len){
            while (!stack.isEmpty() && stack.peek() == popped[j]){
                j++;
                stack.pop();
            }
            while (i < len && pushed[i] != popped[j]){
                stack.push(pushed[i]);
                i++;
            }
            if (i >= len && j < len) return false;
            else {
                i++;
                j++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        L_31 l_31 = new L_31();
        System.out.println(l_31.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1}));
    }
}
