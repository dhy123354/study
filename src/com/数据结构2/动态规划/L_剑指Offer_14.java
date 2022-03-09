package com.数据结构2.动态规划;

public class L_剑指Offer_14 {
    public int cuttingRope(int n) {
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n == 3) return  2;
        int[] dp = new int[n + 1];
        dp[0] = 0;dp[1] = 1;dp[2] = 2;dp[3] = 3;
        int max = 0;
        for (int i = 4; i <= n; i++) {
            max = 0;
            for (int j = 0; j < i/2; j++) {
                if (max < dp[j]*dp[i - j])
                    max = dp[j]*dp[i - j];
                dp[i] = dp[j]*dp[i - j];
            }
        }
        return dp[n];
    }
}
