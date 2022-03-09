package com.数据结构2.动态规划;

public class L_322_零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        int min = Integer.MAX_VALUE;
        if (amount < 1) min =  Integer.MAX_VALUE;

        for (int a : coins){
            if (amount == a)return 1;
        }

        for (int i = 0; i < coins.length; i++) {
            min = Math.min(coinChange(coins,amount - coins[i]),min);
        }
        if (min == Integer.MAX_VALUE) {
            return  -1;
        }
        return min + 1;
    }

    public static int coinChange(int amount, int[] coins) {
        if (amount < 1 || coins == null || coins.length == 0) return -1;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int face : coins) {
                if (i < face) continue;
                int v = dp[i - face];
                if (v < 0 || v >= min) continue;
                min = v;
            }
            if (min == Integer.MAX_VALUE) {
                dp[i] = -1;
            } else {
                dp[i] = min + 1;
            }
        }
        return dp[amount];
    }
}
