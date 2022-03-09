package com.数据结构1.Hash;


import java.util.HashMap;
import java.util.Map;

public class L_1_两数之和 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(nums[0],0);
        for (int i = 1; i < nums.length; i++) {
            int a = target - nums[i];
            if (map.containsKey(a)){
                return new int[]{i,map.get(a)};
            }else {
                map.put(nums[i],i);
            }
        }
        return null;
    }
}
