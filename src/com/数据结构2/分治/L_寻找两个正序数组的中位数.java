package com.数据结构2.分治;

import java.util.Arrays;

public class L_寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            nums[i] = nums1[i];
        }
        for (int j = 0; j < nums2.length; j++) {
            nums[nums1.length + j] =  nums2[j];
        }
        Arrays.sort(nums);
        if (nums.length % 2 == 0) { //偶数个数
            return ((double) (nums[nums.length / 2 - 1] + nums[nums.length / 2])) / 2;
        } else {
            return nums[nums.length / 2];
        }

    }
}
