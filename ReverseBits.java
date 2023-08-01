import org.junit.jupiter.api.Test;

public class ReverseBits {

    @Test
    public void testReverseBits(){
        System.out.println(
                Integer.toBinaryString(reverseBits(0b11111111111111111111111111111101)));
    }

    public int reverseBits(int n) {
        int s = 1;
        for (int i = 0; i < 32; i++) {
            s = (s << 1) + ((n >>> i) & 1);
        }
        return s;
    }
}
