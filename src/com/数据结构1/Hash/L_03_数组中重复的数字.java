package com.数据结构1.Hash;

import java.util.Arrays;
import java.util.HashMap;

public class L_03_数组中重复的数字 {
    //哈希表时间O(n)，空间O(n)，不修改原数据
    public int findRepeatNumber1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if (nums == null) return 0;

        for (int a : nums) {
            if (map.containsKey(a)) return a;
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        return -1;
    }

    //排序，时间O(nlogn)，空间O(logn)，修改了原数据
    public int findRepeatNumber2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i + 1]) return nums[i];
        }
        return -1;
    }

    //二分查找，时间O(nlogn)，空间O(1)，不修改原数据，用时间换空间
     public int findRepeatNumber(int[] nums) {
         //统计nums中元素位于0到m的数量，如果数量大于这个值，那么重复的元素肯定是位于0到m的
         int min = 0 ;
         int max = nums.length-1;
         while(min<max){
             int mid = (max+min)>>1;
             int count = countRange(nums,min,mid);
             if(count > mid-min+1) {
                 max = mid;
             }else{
                 min = mid+1;
             }
         }
         //最后min=max
         return min;
     }

     //统计范围内元素数量,时间O(n)
     private int countRange(int[] nums,int min,int max){
         int count = 0 ;
         for(int num:nums){
             if(num>=min && num<=max){
                 count++;
             }
         }
         return count;
     }
}
