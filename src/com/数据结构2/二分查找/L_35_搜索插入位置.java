package com.数据结构2.二分查找;

public class L_35_搜索插入位置 {
    public int searchInsert(int[] nums, int target) {
        int begin = 0, end = nums.length - 1;
        int index = 0;
        while (begin <= end){
            int mid = (begin + end) >> 1;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                end = mid - 1;
            }else {
                begin = mid + 1;
            }
        }
        return begin;
    }
}
