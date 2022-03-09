package com.数据结构2.UnioFind;

public class L_959_由斜杠划分区域 {
    private class UnionFind{
        private int[] parents;
        private int count;

        public int getCount(){
            return count;
        }

        public UnionFind(int n){
            this.count = n;
            parents = new int[n];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
        }

        public int find(int x){
            while (x != parents[x]){
                int p = parents[x];
                parents[x] = parents[parents[x]];
                x = p;
            }
            return x;
        }

        public void union(int x,int y){
            int p1 = find(x);
            int p2 = find(y);
            if (p1 == p2) return;
            parents[p1] = p2;
            count--;
        }
    }

    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        int size = 4 * N * N;

        UnionFind unionFind = new UnionFind(size);
        for (int i = 0; i < N; i++) {
            char[] row = grid[i].toCharArray();
            for (int j = 0; j < N; j++) {
                // 二维网格转换为一维表格，index 表示将单元格拆分成 4 个小三角形以后，编号为 0 的小三角形的在并查集中的下标
                int index = 4 * (i * N + j);
                char c = row[j];
                // 单元格内合并
                if (c == '/') {
                    // 合并 0、3，合并 1、2
                    unionFind.union(index, index + 3);
                    unionFind.union(index + 1, index + 2);
                } else if (c == '\\') {
                    // 合并 0、1，合并 2、3
                    unionFind.union(index, index + 1);
                    unionFind.union(index + 2, index + 3);
                } else {
                    unionFind.union(index, index + 1);
                    unionFind.union(index + 1, index + 2);
                    unionFind.union(index + 2, index + 3);
                }

                // 单元格间合并
                // 向右合并：1（当前）、3（右一列）
                if (j + 1 < N) {
                    unionFind.union(index + 1, 4 * (i * N + j + 1) + 3);
                }
                // 向下合并：2（当前）、0（下一行）
                if (i + 1 < N) {
                    unionFind.union(index + 2, 4 * ((i + 1) * N + j));
                }
            }
        }
        return unionFind.getCount();
    }
}
