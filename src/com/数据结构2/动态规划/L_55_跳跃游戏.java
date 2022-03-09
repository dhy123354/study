package com.数据结构2.动态规划;

public class L_55_跳跃游戏 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;

        int next = 0;
        for (int i = 0; i < nums.length; i++) {


                next = Math.max(next, i + nums[i]);

        }
        return true;
    }
}
