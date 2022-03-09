package com.剑指offer;

import java.util.Arrays;

public class L_40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) return new int[0];
        return sort(arr,0,arr.length - 1,k - 1);
    }

    public int[] sort(int[] nums,int begin,int end,int k){

        int mid = Partition(nums,begin,end);
        if (mid == k) return Arrays.copyOf(nums,mid + 1);
        return mid > k ? sort(nums,begin,mid - 1,k) : sort(nums,mid + 1,end,k);
    }

    public int Partition(int[] nums, int begin, int end){
        int pivot = nums[begin];
        while (begin < end){
            while (begin < end){
                if (pivot < nums[end])
                    end--;
                else {
                    nums[begin++] = nums[end];
                    break;
                }
            }
            while (begin < end){
                if (pivot > nums[begin])
                    begin++;
                else {
                    nums[end--] = nums[begin];
                    break;
                }
            }
        }
        pivot = nums[begin];
        return begin;
    }

}
