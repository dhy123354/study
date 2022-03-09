package com.数据结构1.Array;

import sun.text.resources.en.FormatData_en_IE;

public class L_48_旋转图像 {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        if (len == 0 || len == 1)return;
        for (int i = 0; i < len; ++i)
            for (int j = 0; j < i; ++j){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }

        for (int i = 0; i < len ; i++) {
            for (int j = 0; j < len/ 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][len - 1 - j];
                matrix[i][len - 1 - j] = tmp;
            }
        }

//        int left = 0;
//        int right = len - 1;
//        while (left < right){
//            for (int i = 0; i < len; ++i){
//                int temp = matrix[i][left];
//                matrix[i][left] = matrix[i][right];
//                matrix[i][right] = temp;
//            }
//            left++;
//            right--;
//        }
    }
}
