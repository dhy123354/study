package com.数据结构2.动态规划;

import com.sun.xml.internal.bind.v2.model.core.ID;
import javafx.scene.effect.SepiaTone;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L_128_最长连续序列 {
    public static void main(String[] args) {

    }

    public int longestConsecutive1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[2];
        Arrays.sort(nums);

        int max = dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int prev = dp[(i - 1) & 1];
            if (nums[i] == nums[i - 1] + 1){
                dp[i & 1] = dp[(i - 1) & 1] + 1;
            }else if (nums[i] == nums[i - 1]){
                dp[i & 1] = dp[(i - 1) & 1];
            } else {
                dp[i & 1] = 1;
            }

            max = Math.max(dp[i & 1],max );
        }
        return max;
    }

    //哈希表
    public int longestConsecutive(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }

        int max = 0;

        for(int num : nums){
            if (!set.contains(num - 1)){
                int cur = num;
                int count = 1;

                while (set.contains(cur + 1)){
                    cur += 1;
                    count += 1;
                }
                max = Math.max(max,count);
            }
        }
        return max;
    }
}
