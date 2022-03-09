package com.数据结构2.回溯;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class L_46_全排列 {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        if (n == 0)return list;
        List<Integer> path = new ArrayList<Integer>();
        boolean[] used = new boolean[n];
        place(nums,0,path,used);
        return list;
    }

    public void place(int[] nums, int row,List<Integer> path,boolean[] used) {
        if (row == nums.length){
            list.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])continue;

            path.add(nums[i]);
            used[i] = true;
            place(nums,row + 1,path,used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
    
}
