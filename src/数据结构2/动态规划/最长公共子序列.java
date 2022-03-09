package 数据结构2.动态规划;

public class 最长公共子序列 {
    public static void main(String[] args) {
        int len = longestCommonSubsequence(new String("1359"),new String("149"));
        System.out.println(len);
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        if (text2 == null || text1 == null) return 0;

        char[] rowNums = text1.toCharArray(),colsNums = text2.toCharArray();
        if (text1.length() < text2.length()){
            rowNums = text2.toCharArray();
            colsNums = text1.toCharArray();
        }

        if (colsNums.length == 0 ) return 0;
        if (rowNums.length == 0) return 0;

        int[] dp = new int[rowNums.length + 1];
        for (int i = 1; i <= rowNums.length; i++) {
            int cur = 0;
            for (int j = 1; j <= colsNums.length; j++) {
                int leftTop = cur;
                cur = dp[j];
                if (rowNums[i - 1] == colsNums[j - 1]){
                    dp[j] = leftTop + 1;
                }else {
                    dp[j] = Math.max(dp[j],dp[j - 1]);
                }
            }
        }
        return dp[colsNums.length];
    }

    public static int longestCommonSubsequence4(String text1, String text2) {
        if (text2 == null || text1 == null) return 0;
        char[] char1 = text1.toCharArray();
        if (char1.length == 0) return 0;
        char[] char2 = text2.toCharArray();
        if (char2.length == 0) return 0;

        int[] dp = new int[char2.length + 1];
        for (int i = 1; i <= char1.length; i++) {
            int cur = 0;
            for (int j = 1; j <= char2.length; j++) {
                int leftTop = cur;
                cur = dp[j];
                if (char1[i - 1] == char2[j - 1]){
                    dp[j] = leftTop + 1;
                }else {
                    dp[j] = Math.max(dp[j],dp[j - 1]);
                }
            }
        }
        return dp[char2.length];
    }

    //滚动数组
    public static int longestCommonSubsequenc3(String text1, String text2) {
        if (text2 == null || text1 == null) return 0;
        char[] char1 = text1.toCharArray();
        if (char1.length == 0) return 0;
        char[] char2 = text2.toCharArray();
        if (char2.length == 0) return 0;

        int[][] dp = new int[2][char2.length + 1];
        for (int i = 1; i <= char1.length; i++) {
            int row = i % 2;
            int prew = (i - 1) % 2;
            for (int j = 1; j <= char2.length; j++){
                if(char1[i - 1] == char2[j - 1]){
                    dp[row][j] = dp[prew][j - 1] + 1;
                }else {
                    dp[row][j] = Math.max(dp[prew][j] ,dp[row][j - 1]);
                }
            }
        }
        return dp[char1.length & 1][char2.length];
    }

    public int longestCommonSubsequence2(String text1, String text2) {
        if (text2 == null || text1 == null) return 0;
        char[] char1 = text1.toCharArray();
        if (char1.length == 0) return 0;
        char[] char2 = text2.toCharArray();
        if (char2.length == 0) return 0;

        return lcs(char1,char1.length,char2,char2.length);
    }

    public int lcs(char[] char1,int i,char[] char2,int j){
        if (i == 0 || j ==0) return 0;
        if (char1[i - 1] != char2[j - 1]){
            return Math.max(
                    lcs(char1,i,char2,j - 1),
                    lcs(char1,i- 1,char2,j));
        }
        return lcs(char1,i - 1,char2,j - 1) + 1;
    }

    public int longestCommonSubsequence1(String text1, String text2) {
        if (text2 == null || text1 == null) return 0;
        char[] char1 = text1.toCharArray();
        if (char1.length == 0) return 0;
        char[] char2 = text2.toCharArray();
        if (char2.length == 0) return 0;

        int[][] dp = new int[char1.length + 1][char2.length + 1];
        for (int i = 1; i <= char1.length; i++) {
            for (int j = 1; j <= char2.length; j++){
                if(char1[i - 1] == char2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j] ,dp[i][j - 1]);
                }
            }
        }
        return dp[char1.length][char2.length];
    }
}
