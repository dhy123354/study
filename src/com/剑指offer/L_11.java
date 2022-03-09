package com.剑指offer;

public class L_11 {
    public int minArray(int[] numbers) {
        int start = 0;
        int end = numbers.length - 1;

        while (start < end){
            int mid = ((end - start) >> 1) + start;
            if (numbers[mid] < numbers[end]){
                end = mid;
            }else if (numbers[end] < numbers[mid]){
                start = mid  + 1;
            }else {
                end--;
            }
        }
        return numbers[start];
    }
}
