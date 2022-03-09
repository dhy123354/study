package com.数据结构2.动态规划;

public class L_42_连续子数组的最大和 {
    public  int maxSubArray1(int[] nums){
        if (nums == nums && nums.length ==0 )return 0;
        int[] dp = new int[nums.length];
        int max = dp[0] = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            int prev = dp[i - 1];
            if (prev > 0){
                dp[i] = dp[i - 1] + nums[i];
            }else {
                dp[i] = nums[i];
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }


}
