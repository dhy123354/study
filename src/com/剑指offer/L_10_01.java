package com.剑指offer;

public class L_10_01 {
    public int numWays1(int n) {
        int MAX = 1000000007;
        if (n < 3)return n == 0 ? 1 : n;
        int numWaysOne = 1;
        int numWaysTwo = 2;
        int numWaysN = 0;
        for (int i = 3; i <= n; i++) {
            numWaysN = (numWaysOne + numWaysTwo)%MAX;

            numWaysOne = numWaysTwo;
            numWaysTwo = numWaysN;
        }
        return numWaysN;
    }

    public int numWays(int n){
        int MAX = 1000000007;
        if (n < 3)return n == 0 ? 1 : n;
        int[] arrays = new int[2];
        arrays[0] = 1;arrays[1] = 2;
        for (int i = 3; i <= n; i++) {
            arrays[n & 1] = arrays[(n - 1)& 1] + arrays[(n - 2)& 1];
        }
        return arrays[n & 1];
    }

}
