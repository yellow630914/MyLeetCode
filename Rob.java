import org.junit.jupiter.api.Test;

public class Rob {
    @Test
    public void testRob(){
        int[] nums = {2,7,9,3,1};
        System.out.println(this.rob(nums));
    }

    /**
     * 把偷這家的收益加進dp1
     * 不偷這家的收益加進dp0
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        //邊界條件
        if (nums == null || nums.length == 0)
            return 0;
        int length = nums.length;
        int dp0 = 0;// 第1家沒偷
        int dp1 = nums[0];// 第1家偷了
        // 從第二個開始判斷
        for (int i = 1; i < length; i++) {
            int temp = Math.max(dp0, dp1); // 先比對上一家的偷與不偷的收益，取最大值暫存下來
            dp1 = dp0 + nums[i]; // 第i家偷的收益
            dp0 = temp; // 第i家不偷的收益
        }
        //最後取最大值
        return Math.max(dp0, dp1);
    }
}
