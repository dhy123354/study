package com.剑指offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class L_56 {
    Map<Integer,Integer> map = new HashMap<>();

    public  int[] singleNumbers(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.remove(nums[i]);
                map.put(nums[i],2);
                count++;
                continue;
            }
            map.put(nums[i], 1);
        }

        Set<Integer> set = map.keySet();
        int[] n = new int[map.size() - count];
        int j = 0;
        for (Integer integer : set) {
            if (map.get(integer) == 1){
                n[j++] = integer;
            }
        }
        return n;
    }
}
