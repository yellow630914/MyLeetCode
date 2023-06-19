import org.junit.jupiter.api.Test;

public class IsPowerOfThree {
    @Test
    public void testIsPowerOfThree(){
        System.out.println(isPowerOfThree(-1));
    }

    public boolean isPowerOfThree(int n){
        if (n == 0){
            return false;
        }
        while (Math.abs(n) != 1){
            if (n % 3 == 0){
                n /= 3;
            } else {
                return false;
            }
        }
        return true;
    }
}
