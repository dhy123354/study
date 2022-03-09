package com.数据结构1.Array;


import java.util.HashMap;
import java.util.Map;

public class L_1_两数之和 {
    public int[] twoSum1(int[] nums, int target) {
        int[] index = new int[1];

        for (int i = 0; i < nums.length; i++) {
            for(int j = nums.length - 1; j > i; j --) {
                if (nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return index;
    }

    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();
        map.put(nums[0],0 );
        for (int i = 1; i < nums.length; i++) {
            int a = target - nums[i];
            if (map.containsKey(a)){
                int index1 = i;
                int index2 = map.get(a);
                return new int[]{index1,index2};
            }else {
                map.put(nums[i],i );
            }
        }
        return null;
    }
}
