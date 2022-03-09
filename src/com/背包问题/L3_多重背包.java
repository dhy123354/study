package com.背包问题;

public class  L3_多重背包 {
    public static int maxValue1(int N, int C, int[] s, int[] v, int[] w){
        int[][] dp = new int[N][C + 1];
        for (int i = 0; i <= C; i++) {
            int amxk = Math.min(i/v[0],s[0]);
            dp[0][i] = amxk * w[0];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= C; j++) {
                // 不考虑第 i 件物品的情况
                int n = dp[i- 1][j];
                // 考虑第 i 件物品的情况
                int y = 0;
                for (int k = 1; k <= s[i]; k++) {
                    if (j < k * v[i]) {
                        break;
                    }
                    y = Math.max(y, dp[i - 1][j - k * v[i]] + k * w[i]);
                }
                dp[i][j] = Math.max(n, y);
            }
        }
        return dp[N - 1][C];
    }

    public static int maxValue(int N, int C, int[] s, int[] v, int[] w) {
        int[] dp = new int[C + 1];
        for (int i = 0; i < N; i++) {
            for (int j = C; j >= v[i]; j--) {
                for (int k = 0; k <= s[i] && j >= k * v[i]; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * v[i]] + k * w[i]);
                }
            }
        }
        return dp[C];
    }

        public static void main(String[] args) {
        int N = 2, C = 5;
        int[] v = {1,2}, w = {1,2}, s = {2,1};
        System.out.println(maxValue(N,C,s,v,w));
    }
}
