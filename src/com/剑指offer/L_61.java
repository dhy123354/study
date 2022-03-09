package com.剑指offer;

import java.util.Arrays;

public class L_61 {

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                count++;
            }else {
                if (nums[i] == nums[i + 1]) return false;
                if (nums[i + 1] == nums[i] + 1)
                    continue;
                if (nums[i + 1] - nums[i] -1 <= count){
                    count -= (nums[i] - nums[i - 1] - 1);
                    continue;
                }
                else return false;
            }
        }
        return true;
    }

}
