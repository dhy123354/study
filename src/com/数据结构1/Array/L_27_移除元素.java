package com.数据结构1.Array;

public class L_27_移除元素 {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if (nums == null) return len;
        int i = 0,j = 0;
        while (j < len){
            if (nums[j] == val){
                j++;
            }else {
                nums[i] = nums[j];
                i++;
                j++;
            }
        }
        return nums == null ? 0 : i + 1;
    }
}
