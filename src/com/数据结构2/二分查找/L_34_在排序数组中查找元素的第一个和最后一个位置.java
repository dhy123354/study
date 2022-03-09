package com.数据结构2.二分查找;


public class L_34_在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int[] a = new int[]{1,-1};
        int first = 0, last = nums.length;
        int begin = 0 , end = nums.length - 1, mid = 0;
        while (begin <= end){
            mid = begin + (end - 1) /2;
            if (nums[mid] >= target){
                end = mid - 1;
                first = mid;
            }else {
                begin = mid + 1;
            }
        }

        begin = 0;
        end = nums.length - 1;
        mid = 0;
        while (begin <= end){
            mid = begin + (end - 1) /2;
            if (target < nums[mid]){
                end = mid - 1;
                last = mid;
            }else {
                begin = mid + 1;
            }
        }
        last = last - 1;
        if (first <= last && nums[first] == target
                && nums[last] == target && 0 <= first
                && last < nums.length) {
            a[0] = first;
            a[1] = last;
        }
        return a;
    }
}
