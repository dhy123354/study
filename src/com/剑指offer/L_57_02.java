package com.剑指offer;

import java.util.LinkedList;
import java.util.List;

public class L_57_02 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> ans = new LinkedList<>();
        // [left,right)
        int left = 1, right = 1, sum = 0;
        for (int i = 1; i <= target / 2 + 1; i++) {
            sum += i;
            right++;
            while (sum > target && left < right) {
                sum -= left;
                left++;
            }
            if (sum == target) {
                int [] tmp = new int [right - left];
                int count = 0;
                for (int j = left; j < right; j++) {
                    tmp[count++] = j;
                }
                ans.add(tmp);
            }
        }
        int [][] ansArray = new int [ans.size()][];
        int count = 0;
        for (int[] item: ans) {
            ansArray[count++] = item;
        }
        return ansArray;
    }
}
