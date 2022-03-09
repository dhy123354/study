package com.数据结构1.Hash;

import java.util.HashMap;
import java.util.Map;

public class L_1512_好数对的数目 {
    //暴力搜素
    public int numIdenticalPairs1(int[] nums) {
        int num = 0;
        int len = nums.length;
        if (nums == null) return 0;
        for (int i = 0;i < len; i++){
            for (int j = i + 1; j < len; j++ ){
                if (nums[i] == nums[j]){
                    num++;
                }
            }
        }
        return num;
    }

    //哈希表
    public int numIdenticalPairs(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        if (nums == null) return 0;

        for (int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int v = entry.getValue();
            ans += v * (v - 1) / 2;
        }
        return ans;
    }


}
