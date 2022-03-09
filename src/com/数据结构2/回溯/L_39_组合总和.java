package com.数据结构2.回溯;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class L_39_组合总和 {
    static List<List<Integer>> list = new ArrayList<>();
    static List<Integer> l1 = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        int sum = 0;
        place(candidates, target, 0);
        return list;
    }

    public static void place(int[] candidates, int target, int row) {
        if (target == 0) {
            list.add(new ArrayList<>(l1));
        }

        if (target < 0 || row >= candidates.length) return;

        for (int i = row; i < candidates.length; i++) {
            l1.add(candidates[i]);
            place(candidates,target - candidates[i],i);
            l1.remove(l1.size() - 1);
        }
    }

    public static void place1(int[] candidates, int target, int row, int sum) {
        if (sum == target) {
            list.add(new ArrayList<>(l1));
            return;
        }
        if (sum > target) return;

        for (int col = 0; col < candidates.length; col++) {
            l1.add(candidates[col]);
            sum += candidates[col];
            place1(candidates, target, col, sum);
            l1.remove(l1.size() - 1);
            sum -= candidates[col];
        }
    }

    public static void main(String[] args) {
        int[] c = {2,3,6,7};
        int d = 7;
        combinationSum(c,d);
        System.out.println(list.toString());
    }
}
