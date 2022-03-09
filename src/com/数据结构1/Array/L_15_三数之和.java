package com.数据结构1.Array;

import sun.security.provider.Sun;

import java.util.*;

public class L_15_三数之和 {
    public List<List<Integer>> threeSum1(int[] nums) {
        Set result =  new  HashSet();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        Collections.sort(list);
                        result.add(list);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> lists = new ArrayList<>();
        int len = nums.length;
        if (nums == nums || len <= 2) return lists;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1])continue;
            int L = i + 1;
            int R = len - 1;
            while (L < R ){
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0){
                    lists.add(Arrays.asList(nums[i] , nums[L] , nums[R]));
                    while (L < R && nums[L] == nums[L + 1])L++;
                    while (L < R && nums[R] == nums[R - 1])R--;
                    L++;
                    R--;
                }else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return lists;
    }
}
