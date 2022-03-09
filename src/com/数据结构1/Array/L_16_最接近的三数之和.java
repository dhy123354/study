package com.数据结构1.Array;

import java.util.Arrays;

public class L_16_最接近的三数之和 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len; i++) {
            int L = i + 1;
            int R = len - 1;
            while (L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if (Math.abs(sum - target) < Math.abs(ans - target))
                    ans = sum;
                if (sum > target)
                    R--;
                else if (sum < target)
                    L++;
                else
                    return ans;
            }
        }
        return ans;
    }
}
