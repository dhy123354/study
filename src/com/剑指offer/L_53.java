package com.剑指offer;

public class L_53 {

    public int search(int[] nums, int target) {
        int count = 0;
        int begin = 0;
        int end = nums.length - 1;
        while (begin < end){
            int mid = (begin + end) >> 1;
            if (nums[mid] >= target){
                end = mid;
            }else if (nums[mid] < target){
                begin = mid + 1;
            }
        }
        while (begin < nums.length && nums[begin++] == target)
            count++;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(8 >> 1);
    }

}
