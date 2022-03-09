package com.数据结构2.回溯;

import java.util.*;

public class L_90_子集2 {
    List<List<Integer>> list = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();
    List<Integer> list1 = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        place(nums,0);
        for (List tmp : set){
            list.add(tmp);
        }
        return list;
    }

    public void place(int[] nums,int row){
        if (row <= nums.length)set.add(new ArrayList<>(list1));
        else return;
        for (int col = row; col < nums.length; col++) {
            list1.add(nums[col]);
            place(nums,col + 1);
            list1.remove(list1.size() - 1);
        }
    }
}
