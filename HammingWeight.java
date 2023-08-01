import org.junit.jupiter.api.Test;

public class HammingWeight {
    @Test
    public void testHammingWeight(){
        System.out.println(hammingWeightAnd(0b11111111111111111111111111111101));
    }

    public int hammingWeight(int n){
        int cnt = 0;
        String bStr = Integer.toBinaryString(n);
        for (int i = 0; i < bStr.length(); i++) {
            if (bStr.charAt(i) == '1'){
                cnt++;
            }
        }
        return cnt;
    }

    public int hammingWeightAnd(int n){
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >>> i) & 1) == 1){
                cnt++;
            }
        }
        return cnt;
    }

}
