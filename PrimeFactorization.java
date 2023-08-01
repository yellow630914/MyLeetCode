import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {

    @Test
    public void testPrimeFactorization(){
        int i = 888;
        System.out.println(this.printFactor(i));
    }

    private List<Integer> printFactor(int n){
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0 && n != i){
                n = n/i;
                result.add(i);
            }
            if (n == i){
                result.add(i);
            }
        }
        return result;
    }
}
