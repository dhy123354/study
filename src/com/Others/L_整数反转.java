package com.Others;

public class L_整数反转 {
    public int reverse(int x) {
        if(x == 0 ) return x;
        if (x > Integer.MAX_VALUE) return 0;
        if (x < Integer.MIN_VALUE) return 0;
        int conut = 0;
        int a = Math.abs(x);
        while (a >= 1){
            a /= 10;
            conut++;
        }
        int c = Math.abs(x) ,d = 0;
        while (Math.abs(c) >= 1){
            int t = c % 10;
            d += t * Math.pow(10,conut - 1);
            c = (c - t)/10;
            conut--;
        }
        return d == d ? d : 0;
    }
}
