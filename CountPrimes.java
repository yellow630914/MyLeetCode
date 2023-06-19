import org.junit.jupiter.api.Test;

public class CountPrimes {
    @Test
    public void testCountPrimes(){
        int num = 499979;
        System.out.println(countPrimes(num));
    }

    public int countPrimes(int n) {
        boolean[] arr = new boolean[n];
        int cnt = 0;
        for(int i = 2; i < n; i++) {
            if(arr[i]) continue;
            cnt++;
            for(int j = i; j < n; j+=i) {
                arr[j] = true;
            }
        }
        return cnt;
    }
}
