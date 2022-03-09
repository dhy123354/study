package com.Others;

public class L_13_罗马数字转整数 {
    int[] val = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] strings = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public int romanToInt(String s) {
        int len = s.length();
        int max = 0;
        for (int i = 0,j = 0; i < strings.length && j < len ; i++) {
            int cv = val[i];
            String cs = strings[i];
            int size = cs.length();
            while (j + size <= len && s.substring(j,j + size).equals(cs)){
                max += cv;
                j += size;
            }
        }
        return max;
    }
}
