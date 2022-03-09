package com.剑指offer;

public class L_42 {
    public int maxSubArray(int[] nums){
        if (nums == null && nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] >= 0)
                dp[i] = nums[i] + dp[i - 1];
            else
                dp[i] = nums[i];
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
