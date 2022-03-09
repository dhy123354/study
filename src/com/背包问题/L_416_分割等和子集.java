package com.背包问题;

public class L_416_分割等和子集 {
    public boolean canPartition1(int[] nums) {
        int sum = 0;
        int C;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;
        C = sum / 2 ;
        int[] dp = new int[C + 1];

        for (int i = 1; i <= nums.length; i++) {
            int t = nums[i - 1];
            for (int j = C; j >= t; j--) {
                dp[j] = Math.max(dp[j],dp[j - t] + t);
            }
        }
        return dp[C] == C;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        int C;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;
        C = sum / 2 ;
        int[] dp = new int[C + 1];

        for (int i = 1; i <= C; i++) {
            dp[i] = Integer.MIN_VALUE;
        }

        for (int i = 1; i <= nums.length; i++) {
            int t = nums[i - 1];
            for (int j = C; j >= t; j--) {
                dp[j] = Math.max(dp[j],dp[j - t] + t);
            }
        }
        return dp[C] < 0 ? false : true;
    }
}

