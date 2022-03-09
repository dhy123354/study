package com.剑指offer;

import java.util.Arrays;

public class L_53_02 {

    public int missingNumber1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i])
                return i;
        }
        return nums.length;
    }

    public int missingNumber(int[] nums) { ;
        int begin = 0;
        int end = nums.length - 1;
        while (begin < end){
            int mid = (begin + end) >> 1;
            if (nums[mid] != mid){
                if (mid == 0 || nums[mid - 1] == mid - 1)
                    return mid;
                else
                    end = mid - 1;
            }
            else
                begin = mid + 1;
        }
        return begin;
    }
}
