package com.剑指offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class L_56_02 {

    Map<Integer,Integer> map = new HashMap<>();

    public  int singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.remove(nums[i]);
                map.put(nums[i],2);
                continue;
            }
            map.put(nums[i], 1);
        }

        Set<Integer> set = map.keySet();
        for (Integer integer : set) {
            if (map.get(integer) == 1){
                return integer;
            }
        }
        return -1;
    }
}
