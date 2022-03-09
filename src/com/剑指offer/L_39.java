package com.剑指offer;

import java.util.HashMap;
import java.util.Map;

public class L_39 {

    public int majorityElement1(int[] nums) {
        if (nums.length <= 1) return nums[0];
        Map<Integer,Integer> map = new HashMap<>();
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                Integer integer = map.get(nums[i]) + 1;
                map.put(nums[i], integer);
                if (integer > nums.length / 2)
                    return nums[i];
            }
            if (!map.containsKey(nums[i]))
                map.put(nums[i],1);
        }
        return 0;
    }

    public int majorityElement(int[] nums) {
        int x = 0, votes = 0, count = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        // 验证 x 是否为众数
        for(int num : nums)
            if(num == x) count++;
        return count > nums.length / 2 ? x : 0; // 当无众数时返回 0
    }

}
