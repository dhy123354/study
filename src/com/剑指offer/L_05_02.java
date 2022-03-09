package com.剑指offer;

public class L_05_02 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int li = n - 1,ri = m - 1;
        int ai = m + n - 1;

        while (li >= 0 && ri >= 0){
            if (nums1[ri] > nums2[li]){
                nums1[ai--] = nums1[ri--];
            }else {
                nums1[ai--] = nums2[li--];
            }
        }
        System.arraycopy(nums2, 0, nums1, 0, ri + 1);
    }

}
