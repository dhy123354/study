package com.数据结构1.Tree;

import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class L_113_路径总和2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine().trim());
        int n = Integer.parseInt(br.readLine().trim());
        int[][] grid = new int[m][n];
        for(int i = 0; i < m; i++){
            String[] row = br.readLine().trim().split(" ");
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(row[j]);
                System.out.println(row[j]);
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0)
                    grid[i][j] = grid[i][j];
                else if(i == 0)
                    grid[i][j] += grid[i][j - 1];     // 上边界只能从左边过来
                else if(j == 0)
                    grid[i][j] += grid[i - 1][j];     // 左边界只能从上边过来
                else      // 选择两种方案中路径小的
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        System.out.println(grid[m - 1][n - 1]);
    }
}