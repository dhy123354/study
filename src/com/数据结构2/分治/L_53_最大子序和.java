package com.数据结构2.分治;

public class L_53_最大子序和 {
    //暴力搜索
    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int Max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                Max = Math.max(Max,sum);
            }
        }
        return Max;
    }

    //
    public int maxSubArray(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        return maxSubArray(nums,0,nums.length);
    }

    public int maxSubArray(int[] nums,int begin ,int end){
        if (end - begin < 2) return nums[begin];
        int mid = (begin + end) >> 1;

        int leftMax = Integer.MIN_VALUE;
        int leftSum = 0;
        for (int i = mid - 1; i >= begin; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax,leftSum);
        }

        int rightMax = Integer.MIN_VALUE;
        int rightSum = 0;
        for (int i = mid; i < end; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightMax,rightSum);
        }

        int Max = leftMax + rightMax;

        return Math.max(Max,
                Math.max(
                        maxSubArray(nums,begin,mid),
                        maxSubArray(nums,mid,end)
                ));
    }
}
