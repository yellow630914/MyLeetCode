import org.junit.jupiter.api.Test;

public class TestDoWhile {
    @Test
    public void testDoWhile(){
        this.test1();
    }

    private void test1(){
        int x = 0,y = 10;
        do{
            if (y < 4) {
                break;
            } else if (--y > 6){
                ++x;
            }
        } while (x++ < 6);
        System.out.println(x);
        System.out.println(y);
    }
}
