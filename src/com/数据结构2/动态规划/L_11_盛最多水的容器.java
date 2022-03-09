package com.数据结构2.动态规划;

import com.sun.org.glassfish.external.amx.AMX;

public class L_11_盛最多水的容器 {
    public static int maxArea1(int[] height) {
        if (height == null || height.length <= 1)return 0;
        int len = height.length;
        int max = 0;
        for (int i = 1; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                max = Math.max(max,(j - i) *(Math.min(height[i - 1],height[j - 1])));
            }
        }
        return max;
    }

    public static int maxArea(int[] height) {
        if (height == null || height.length <= 1)return 0;
        int left = 0,right = height.length - 1;
        int max = 0;
        while (left < right){
            max = Math.max(max,(right - left) * (Math.min(height[right],height[left])));
            if (height[right] < height[left]) --right;
            else ++left;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {4,3,2,1,4};
        System.out.println(maxArea(height));
    }
}
