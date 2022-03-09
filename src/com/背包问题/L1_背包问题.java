package com.背包问题;

public class L1_背包问题 {
    public int maxValue1(int N, int C, int[] v, int[] w){
        if (v == null || v.length == 0)return 0;
        if (w == null || w.length == 0)return 0;
        if (C <= 0) return 0;

        int[][] dp = new int[N][C + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= C; j++) {
                if (j < w[i - 1]){
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j - w[i - 1]] + v[i -1],dp[i - 1][j]);
                }
            }
        }
        return dp[N][C];
    }

    public int maxValue(int N, int C, int[] v, int[] w){
        if (v == null || v.length == 0)return 0;
        if (w == null || w.length == 0)return 0;
        if (C <= 0) return 0;

        int[][] dp = new int[2][C + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= C; j++) {
                if (j < w[(i - 1) & 1]){
                    dp[i & 1][j] = dp[(i - 1) & 1][j];
                }else {
                    dp[i & 1][j] = Math.max(dp[(i - 1) & 1][j - w[i - 1]] + v[i -1],dp[(i - 1) & 1][j]);
                }
            }
        }
        return dp[N & 1][C];
    }
}
