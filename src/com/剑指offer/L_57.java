package com.剑指offer;

public class L_57 {

    public int[] twoSum(int[] nums, int target) {
        int end = nums.length - 1;
        int begin = 0;
        while (begin < end){
            long curSum = nums[begin] + nums[end];
            if (curSum == target)
                return new int[]{nums[begin],nums[end]};
            else if (curSum > target)
                end--;
            else
                begin++;
        }
        return null;
    }

}
