package 数据结构2.动态规划.背包问题;

public class Knapsack {
    public static void main(String[] args) {
        int[] values = {6, 3, 5, 4, 6};
        int[] weights = {2, 2, 6, 5, 4};
        int capacity = 10;
        System.out.println(maxValueExactly(values, weights, capacity));
        System.out.println(maxValue3(values, weights, capacity));
    }

   static int maxValue3(int[] w, int[] v, int C) {
        int N = v.length;
        int[][] dp = new int[N][C+1];
        // 先处理「考虑第一件物品」的情况
        for (int i = 0; i <= C; i++) {
            dp[0][i] = i >= v[0] ? w[0] : 0;
        }
        // 再处理「考虑其余物品」的情况
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < C + 1; j++) {
                // 不选该物品
                int n = dp[i-1][j];
                // 选择该物品，前提「剩余容量」大于等于「物品体积」
                int y = j >= v[i] ? dp[i-1][j-v[i]] + w[i] : 0;
                dp[i][j] = Math.max(n, y);
            }
        }
        return dp[N-1][C];
    }

    static int maxValueExactly(int[] values, int[] weights, int capacity){
        if (values.length == 0 || values == null) return 0;
        if (weights.length == 0 || weights == null) return 0;
        if (weights.length != values.length) return 0;
        if (capacity <= 0) return 0;
        int[] dp = new int[capacity + 1];

        for (int i = 1; i <= capacity; i++) {
            dp[i] = Integer.MIN_VALUE;
        }

        for (int i = 1; i <= values.length; i++) {
            for (int j = capacity; j >= weights[i - 1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weights[i - 1]] + values[i - 1]);
            }
        }
        return dp[capacity] < 0 ? -1 : dp[capacity];
    }

    //一维数组
    static int maxValue(int[] values, int[] weights, int capacity) {
        if (values == null || values.length == 0) return 0;
        if (weights == null || weights.length == 0) return 0;
        if (values.length != weights.length || capacity <= 0) return 0;
        int[] dp = new int[capacity + 1];
        for (int i = 1; i <= values.length; i++) {
            for (int j = capacity; j >= weights[i - 1]; j--) {
                dp[j] = Math.max(dp[j], values[i - 1] + dp[j - weights[i - 1]]);
            }
        }
        return dp[capacity];
    }

    static int maxValue1(int[] values, int[] weights, int capacity) {
        if (values == null || values.length == 0) return 0;
        if (weights == null || weights.length == 0) return 0;
        if (values.length != weights.length || capacity <= 0) return 0;
        int[][] dp = new int[values.length + 1][capacity + 1];
        for (int i = 1; i <= values.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j < weights[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            values[i - 1] + dp[i - 1][j - weights[i - 1]]);
                }
            }
        }
        return dp[values.length][capacity];
    }
}
