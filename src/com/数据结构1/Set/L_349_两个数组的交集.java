package com.数据结构1.Set;

import java.util.Set;
import java.util.TreeSet;

public class L_349_两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new TreeSet<>();
        Set<Integer> set1 = new TreeSet<>();

        for (int i :nums1){
            set.add(nums1[i]);
        }
        for (int i :nums2){
            if (set.contains(nums2[i])){
                set1.add(nums2[i]);
            }
        }

        int num[] = new int[set1.size()];
       int a = 0;
        for (int i: set1){
            num[a] = i;
            a++;
        }
    return num;
    }
}
