package com.背包问题;

public class L_518_零钱兑换II {
    public int change1(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int val = coins[i - 1];
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int k = 1; k * val <= j; k++) {
                    dp[i][j] += dp[i - 1][j - k * val];
                }
            }
        }
        return dp[n][amount];
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int val = coins[i - 1];
            for (int j = val; j <= amount; j++) {
                dp[j] += dp[j - val];
            }
        }
        return dp[amount];
    }
}
