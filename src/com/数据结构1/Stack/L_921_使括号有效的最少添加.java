package com.数据结构1.Stack;

import java.util.Stack;

public class L_921_使括号有效的最少添加 {
    public int minAddToMakeValid1(String s) {
        Stack<Character> stack = new Stack<>();
        if (s == null) return 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (stack.isEmpty()) {
                sum++;
            } else {
                stack.pop();
            }
        }
        return sum + stack.size();
    }

    public int minAddToMakeValid2(String S) {
        if(S.length()==0)return 0;

        Stack<Character> stack=new Stack();

        char[] chars = S.toCharArray();

        for (int i = 0; i <chars.length; i++) {

            if(!stack.isEmpty()&&stack.peek()=='('&&chars[i]==')'){
                stack.pop();
                continue;
            }
            stack.push(chars[i]);
        }
        return  stack.size();
    }

    public int minAddToMakeValid(String S){
         if (S.length() == 0) return 0;
         Stack<Character> stack = new Stack<>();

         int count = 0;
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '('){
                stack.push(chars[i]);
            }else if (stack.isEmpty()){
                count ++;
            }else {
                stack.pop();
            }
        }

        return count + stack.size();
    }
}
