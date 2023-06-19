import org.junit.jupiter.api.Test;

public class MaxSubArray {
    @Test
    public void testMaxSubArray(){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(this.maxSubArray1(nums));
        System.out.println(this.maxSubArray2(nums));
    }

    /**
     * 動態規劃
     * @param num
     * @return
     */
    public int maxSubArray1(int[] num) {
        int length = num.length;
        int[] dp = new int[length];
        // 邊界條件
        dp[0] = num[0];
        int max = dp[0];
        for (int i = 1; i < length; i++) {
            // 轉移公式
            // 將之前的收益與現在的值結合，如果之前的收益是虧本狀態則將之拋棄，只記錄現在的值。
            dp[i] = Math.max(dp[i - 1], 0) + num[i];
            // 紀錄最大值
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 動態規劃2
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int length = nums.length;
        int cur = nums[0];
        int max = cur;
        for (int i = 1; i < length; i++) {
            // 將之前的收益與現在的值結合產生現在的收益，如果之前的收益是虧本狀態則將之拋棄，只記錄現在的值。
            cur = Math.max(cur, 0) + nums[i];
            // 紀錄最大值
            max = Math.max(max, cur);
        }
        return max;
    }

}
