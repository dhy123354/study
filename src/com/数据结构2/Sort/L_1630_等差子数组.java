package com.数据结构2.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L_1630_等差子数组 {
    public List<Boolean> checkArithmeticSubarrays1(int[] nums, int[] l, int[] r) {
        int len1 = l.length;
        List<Boolean> arrayList = new ArrayList<>(len1);
        int[] a = new int[len1];
        for (int i = 0; i < len1; i++) {
            int[] temp = new int[r[i] - l[i] + 1];
            for (int j = l[i];j <= r[i]; j++){
                temp[j - l[i]] = nums[j];
            }
            Arrays.sort(temp);
            arrayList.add(checkTempArray(temp));
        }
        return arrayList;
    }

    private boolean checkTempArray(int[] arr){
        for(int i = 2, iMax = arr.length;i < iMax;i++) {
            if(arr[i] - arr[i - 1] != arr[i - 1] - arr[i - 2]) {
                return false;
            }
        }
        return true;
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int len1 = l.length;
        List<Boolean> arrayList = new ArrayList<>(len1);
        boolean[] c = new boolean[len1];
        int[] a = new int[len1];
        for (int i = 0; i < len1; i++) {
            int[] temp = new int[r[i] - l[i] + 1];
            for (int j = l[i];j <= r[i]; j++){
                temp[j - l[i]] = nums[j];
            }
            Arrays.sort(temp);
            int dif = temp[1] - temp[0];
            for (int j = 1; j < temp.length; j++) {
                if (temp[j] - temp[j - 1] != dif){
                    c[i] = false;
                }else {
                    c[i] = true;
                }
            }
            arrayList.add(c[i]);
        }
        return arrayList;
    }
}
