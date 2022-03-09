package com.数据结构1.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L_18_四数之和 {
    public List<List<Integer>> threeSum(int[] nums,int target){
        List<List<Integer>> lists = new ArrayList<>();
        int len = nums.length;
        if (nums == nums || len <= 3) return lists;
        Arrays.sort(nums);
        for (int j = 0;j < len;j ++){
            if (j > 0 && nums[j] == nums[j - 1]) continue;
            for (int i = j + 1; i < len; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                int L = i + 1;
                int R = len - 1;
                while (L < R) {
                    int sum = nums[j]+ nums[i] + nums[L] + nums[R];
                    if (sum == target) {
                        lists.add(Arrays.asList(nums[i], nums[L], nums[R]));
                        while (L < R && nums[L] == nums[L + 1]) L++;
                        while (L < R && nums[R] == nums[R - 1]) R--;
                        L++;
                        R--;
                    } else if (sum < target) L++;
                    else if (sum > target) R--;
                }
            }
        }
        return lists;
    }
}
