import org.junit.jupiter.api.Test;

public class DPCoinCharge {
    @Test
    public void testDPCoinCharge() {
        int[] coinsValues = {2,5,10};
        int n = 33;
        int maxTypes = chargeTypes(coinsValues, n);
        System.out.println(maxTypes);
    }

    // 遍歷每一種硬幣在n值的可能性
    public static int chargeTypes(int[] coins, int amount){
        int m = coins.length;
        int[][] c = new int[m+1][amount+1];

        //基准条件,可参考下面的递归代码
        for(int i = 0; i <=m; i++)
            c[i][0] = 1;
        for(int i = 1; i <=amount; i++)
            c[0][i] = 0;


        // i 代表可以使用的硬幣種類，例：c[1]時，代表正在使用第1與第2種硬幣找零。
        for(int i = 1; i <=m; i++) {
            // j 代表要找零錢數，會從1遍歷到n
            for(int j = 1; j <=amount; j++) {
                if(j < coins[i-1]) { // 當現在使用硬幣無法找零，直接繼承上一種硬幣的方法數
                    c[i][j] = c[i-1][j];
                    continue;
                }
                //當現在使用硬幣可以找零的情况下, 上一種硬幣的方法數 + 新增的方法數
                c[i][j] = c[i-1][j] + c[i][j - coins[i-1]];//coinsValues下标从0开始
            }
        }
        return c[m][amount];
    }

    //递归实现
    public static int recursiveChargeTypes(int[] coinsValues, int m, int n)
    {
        //基准条件 可以 通过画一个简单的实例 分析来得出. 比如 recursiveChargeTypes({1,3,4}, 3, 5)
        if(n == 0)
            return 1;
        if(n < 0)
            return 0;
        if(m <= 0)
            return 0;
        else
            return recursiveChargeTypes(coinsValues, m-1, n) + recursiveChargeTypes(coinsValues, m, n-coinsValues[m]);
    }
}
