package com.剑指offer;

public class L_10 {
    public int fib(int n) {
        int MAX = 1000000007;
        int[] result = new int[]{0,1};
        if (n<2)return result[n];
        int fibOne = 1;
        int fibTwo = 0;
        int fibCur = 0;
        for (int i = 2; i <= n; ++i) {
            fibCur = (fibOne + fibTwo)%MAX;

            fibTwo = fibOne  ;
            fibOne= fibCur;
        }
        return fibCur;
    }
}
