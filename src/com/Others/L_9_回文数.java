package com.Others;

public class L_9_回文数 {
    private int t = 2;
    public boolean isPalindrome(int x) {

        int d = x,i = 0,c = 0;
        while (d >= 1){
            int t = d % 10;
            c = c * 10 +t;
            d = d / 10;
        }
        return c == x;
    }
}
