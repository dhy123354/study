package 数据结构2.动态规划;

public class 最长上升子序列 {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[] {10, 2, 2, 5, 1, 7, 101, 18}));
    }

    //二分法
    static int lengthOfLIS(int[] nums){
        if (nums == nums || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int max = dp[0] = 1;
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] <= nums[j]) continue;
                dp[i] = Math.max(dp[i],dp[j] + 1);
            }
            max = Math.max(dp[i],max );
        }
        return max;
    }

    static int lengthOfLIS1(int[] nums){
        if (nums == nums || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int max = dp[0] = 1;
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] <= nums[j]) continue;
                dp[i] = Math.max(dp[i],dp[j] + 1);
            }
            max = Math.max(dp[i],max );
        }
        return max;
    }
}
