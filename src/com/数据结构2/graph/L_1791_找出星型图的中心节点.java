package com.数据结构2.graph;

public class L_1791_找出星型图的中心节点 {
    public int findCenter(int[][] edges) {
        if (edges == null) return 0;
        int c = 0;
         if (edges[1][0] == edges[0][0] || edges[1][0] == edges[0][1])  {
             c = edges[1][0];
         }
        if (edges[1][1] == edges[0][0] || edges[1][1] == edges[0][1])  {
            c = edges[1][1];
        }
        return c;
    }
}
