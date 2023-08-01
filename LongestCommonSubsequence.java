import org.junit.jupiter.api.Test;

public class LongestCommonSubsequence {
    @Test
    public void testLongestCommonSubsequence(){
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(this.longestCommonSubsequence(text1, text2));
    }

    private int longestCommonSubsequence(String text1,String text2){
        int m = text1.length();int n = text2.length();
        // 各新增一排表示空字串時的情況
        int[][] dp = new int[m+1][n+1];
        // 不管是哪一維度，第0排都是0(共同子序列長度為0)
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
