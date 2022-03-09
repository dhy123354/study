package com.数据结构1.Array;

public class L_26_删除有序数组中的重复性 {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (nums == nums || len == 1)return len;
        int i = 0,j = 1;
        while (j < len){
            if (nums[i] == nums[j]){
                j++;
            }else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return i + 1;
    }
}