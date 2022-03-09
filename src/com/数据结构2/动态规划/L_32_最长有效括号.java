package com.数据结构2.动态规划;

import javafx.scene.control.DatePicker;
import 数据结构基础.Stack.Stack;

import java.util.Deque;
import java.util.LinkedList;

public class L_32_最长有效括号 {
    public int longestValidParenthese1(String s) {
        if (s == null)return 0;
        int Max = 0;
        int[] dp =  new int[s.length() + 1];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')'){
                if (s.charAt(i - 1) == ')'){
                    if (i - 2 > 0){
                        dp[i] = dp[i - 2] + 2;
                    }else {
                        dp[i] = 2;
                    }
                }else if (s.charAt(i - dp[i - 1] - 1) == '('){
                    if (i - dp[i - 1] - 2 >= 0){
                        dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                    } else {
                        dp[i] = dp[i - 1] + 2;
                    }
                }
            }
            Max = Math.max(Max,dp[i]);
        }
        return Max;
    }

    public int longestValidParentheses(String s){
        Deque<Integer>stack = new LinkedList<Integer>();
        // 向栈中预置一个-1，将计算长度的方式转化成“）”的下标减去出栈后栈顶元素的下标
        stack.push(-1);
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            if ('('==s.charAt(i)) {
                stack.push(i);
            }
            if (')'==s.charAt(i)) {
                stack.pop();
                // 如栈空，则注入新的i作为预置下标
                if (stack.isEmpty()) {
                    stack.push(i);
                }
                len = Math.max(len, i-stack.peek());

            }
        }
        return len;
    }
}
