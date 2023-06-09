import org.junit.jupiter.api.Test;

public class ClimbStairs {
    @Test
    public void testClimbStairs(){
        System.out.println(climbStairs(15));
    }

    /**
     * dp[n]是由dp[n-1]+dp[n-2]組成。
     * 例如：dp[1] = 1、dp[2] = 2，dp[3] = dp[2] + dp[1] = 3。
     * @param n
     * @return
     */
    public int climbStairs(int n){
        if (n <= 1)
            return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i -1] + dp[i - 2];
        }
        return dp[n];
    }
}
