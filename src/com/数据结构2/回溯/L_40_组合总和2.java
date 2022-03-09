package com.数据结构2.回溯;

import java.util.*;

public class L_40_组合总和2 {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> l1 = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        place(candidates, target, 0);
        return list;
    }

    public void place(int[] candidates, int target, int row) {
        if (target == 0) {
            list.add(new ArrayList<>(l1));
            return;
        }

        for (int i = row; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                if (i > 0 && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                l1.add(candidates[i]);
                place(candidates, target - candidates[i], i + 1);
                l1.remove(l1.size() - 1);
            }
        }
    }

    public static void main(String[] args) {

    }
}
