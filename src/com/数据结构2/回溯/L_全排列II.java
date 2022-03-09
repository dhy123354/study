package com.数据结构2.回溯;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L_全排列II {
    List<List<Integer>> list = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();
    List<Integer> list1 = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        if (n == 0) return list;
        used = new boolean[n];
        place(nums,0);
        for (List list2: set){
            list.add(list2);
        }
        return list;
    }

    public void place(int[] nums,int row){
        if (row == nums.length){
            set.add(new ArrayList<>(list1));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])continue;

            list1.add(nums[i]);
            used[i] = true;
            place(nums,row + 1);
            list1.remove(list1.size() - 1);
            used[i] = false;
        }
    }
}
