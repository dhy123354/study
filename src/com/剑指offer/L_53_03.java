package com.剑指offer;

public class L_53_03 {

    public int equalNumber(int[] nums){
        int begin = 0;
        int end = nums.length - 1;
        while (begin <= end){
            int mid = (begin + end) >> 1;
            if (nums[mid] < mid)
                begin = mid + 1;
            else if (nums[mid] > mid)
                end = mid - 1;
            else
                return begin;
        }
        return -1;
    }

    public static void main(String[] args) {
        L_53_03 l_53_03 = new L_53_03();
        int[] nums = {1};
        System.out.println(l_53_03.equalNumber(nums));
    }

}
