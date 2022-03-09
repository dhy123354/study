package com.背包问题;

import sun.text.resources.en.FormatData_en_IE;

public class L_322_零钱兑换 {
    public static int coinChange1(int[] coins,int amount){
        if (coins == null || amount == 0) return 0;
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= len; i++) {
            int val = coins[i - 1];
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int k = 1; k * val <= j; k++) {
                    if (dp[i - 1][j - k * val] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][j-k*val] + k);
                    }
                }
            }
        }
        return dp[len][amount] == Integer.MAX_VALUE ? -1 : dp[len][amount];
    }

    static  int INF = 0x3f3f3f3f;
    public static int coinChange(int[] cs, int cnt) {
        int n = cs.length;
        int[] f = new int[cnt + 1];
        for (int i = 1; i <= cnt; i++) f[i] = INF;
        for (int i = 1; i <= n; i++) {
            int val = cs[i - 1];
            for (int j = val; j <= cnt; j++) {
                f[j] = Math.min(f[j], f[j - val] + 1);
                System.out.println("f[" +j +"]_"+val+"--" + f[j]);
            }
            System.out.println("---------");
        }
        return f[cnt] == INF ? -1 : f[cnt];
    }

    public static void main(String[] args) {
        int[] cs = new int[]{1,2,3};
        int cnt = 5;
        System.out.println(coinChange(cs,cnt));
    }
}
