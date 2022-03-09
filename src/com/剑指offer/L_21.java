package com.剑指offer;

public class L_21 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        int[] arrs = exchange(nums);
        for (int num : arrs) {
            System.out.println(num);
        }
    }

    public static int[] exchange(int[] nums) {
        int begin = 0,i = 0;
        int end = nums.length - 1,l = nums.length- 1;
        while (begin <= end){
            while (begin < end && nums[begin] % 2 == 1){
                begin++;
            }

            while (begin < end && nums[end] % 2 == 0){
                end--;
            }

            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
        }
        return nums;
    }

}
