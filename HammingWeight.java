import org.junit.jupiter.api.Test;

public class HammingWeight {
    @Test
    public void testHammingWeight(){
        System.out.println(hammingWeight(146));
    }

    public int hammingWeight(int n){
        int cnt = 0;
        n = Math.abs(n);
        if (n == 0){
            return cnt;
        }
        cnt++;
        while (n != 1){
            if (n % 2 == 1){
                cnt++;
            }
            n /= 2;
        }
        return cnt;
    }

}
