package com.数据结构1.Array;

public class L_1476_子矩形查询 {
    class SubrectangleQueries {
        private int[][] a;

        public SubrectangleQueries(int[][] rectangle) {
            a=new int[rectangle.length][rectangle[0].length];
            for(int i=0;i<a.length;i++){
                a[i]=rectangle[i].clone();
            }
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            if ( a != null){
                for (int j = row1; j <= row2 ;j++){
                    for (int i =col1; i <= col2; i++){
                        a[j][i] = newValue;
                    }
                }
            }
        }

        public int getValue(int row, int col) {
            return a[row][col];
        }
    }
}
