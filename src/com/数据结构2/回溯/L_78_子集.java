package com.数据结构2.回溯;

import java.util.ArrayList;
import java.util.List;

public class L_78_子集 {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> list1 = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) return list;
        place(nums,0);
        return list;
    }

    private void place(int[] nums, int row) {
        list.add(new ArrayList<>(list1));
        for (int col = row; col < nums.length; col++) {
            list1.add(nums[col]);
            place(nums,col + 1);
            list1.remove(list1.size() - 1);
        }
    }
}
