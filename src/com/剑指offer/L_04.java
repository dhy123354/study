package com.剑指offer;

public class L_04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)return false;
        int rows = matrix.length;
        int colums = matrix[0].length;

        if (matrix != null && rows > 0 && colums > 0) {
            int row = 0;
            int colum = matrix[0].length - 1;
            while (row < rows && colum >= 0) {
                if (target == matrix[row][colum]) return true;
                if (target > matrix[row][colum]) {
                    row++;
                } else {
                    colum--;
                }
            }
        }
        return false;
    }
}
