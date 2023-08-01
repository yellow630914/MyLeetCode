import org.junit.jupiter.api.Test;

public class HammingDistance {
    @Test
    public void testHammingDistance(){
        int x = 1;
        int y = 4;
        System.out.println(hammingDistance(x,y));
    }

    public int hammingDistance(int x,int y){
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            if (((x >>> i) & 1) != ((y >>> i) & 1)){
                cnt++;
            }
        }
        return cnt;
    }
}
