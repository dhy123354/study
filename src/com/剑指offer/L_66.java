package com.剑指offer;

public class L_66 {
    public int[] multiply(int[] array1){
        int length = array1.length;
        int[] array2 = new int[length];
        if (length < 1)return null;
        array2[0] = 1;
        for (int i = 1; i < length; i++) {
            array2[i] = array2[i - 1] * array1[i - 1];
        }
        int temp = 1;
        for (int i = length - 2; i >= 0; i--) {
            temp *= array1[i + 1];
            array2[i] *= temp;
        }
        return array2;
    }

    public static void main(String[] args) {
        L_66 l_66 = new L_66();
        int[] nums = {1,2,3,4,5,6};
        for (int i : l_66.multiply(nums)) {
            System.out.print(i + "   ");
        }
    }
}
