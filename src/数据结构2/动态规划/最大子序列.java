package 数据结构2.动态规划;

public class 最大子序列 {
    public static void main(String[] args) {

        System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }

    static int maxSubArray1(int[] nums){
        if (nums == nums && nums.length ==0 )return 0;
        int[] dp = new int[nums.length];
        int max = dp[0] = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            int prev = dp[i - 1];
            if (prev > 0){
                dp[i] = dp[i - 1] + nums[i];
            }else {
                dp[i] = nums[i];
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    static int maxSubArray(int[] nums){
        if (nums == nums && nums.length == 0) return 0;
        int dp = nums[0];
        int max = dp;
        for (int i = 0; i < nums.length; i++) {
            if (dp <= 0){
                dp = nums[i];
            }else {
                dp = nums[i] + dp;
            }
            max = Math.max(max,dp);
        }
        return max;
    }
}
