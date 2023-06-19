import org.junit.jupiter.api.Test;

public class MaxProfit {
    @Test
    public void testMaxProfit(){
        int[] ary = {7,1,4,3,6,5};
        System.out.println(maxProfit(ary));
        System.out.println(maxProfitWithDynamic(ary));
    }

    /**
     * 雙指針方式，i是一指針遍歷price數組，min是一指針儲存i遍歷過最小值。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices){
        if (prices.length <= 1)
            return 0;
        int diff = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min,prices[i]);
            diff = Math.max(prices[i] - min,diff);
        }
        return diff;
    }

    /**
     * 動態規劃解法。
     * @param prices
     * @return
     */
    public int maxProfitWithDynamic(int[] prices){
        if (prices.length <= 1)
            return 0;
        int hold = -prices[0];
        int noHold = 0;
        for (int i = 0; i < prices.length; i++) {
            noHold = Math.max(noHold, hold + prices[i]);
            hold = Math.max(hold, -prices[i]);
        }
        return noHold;
    }
}
