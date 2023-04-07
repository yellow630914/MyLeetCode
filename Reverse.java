import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Reverse {
    @Test
    public void testReverse(){
        int x = 1673549236;
        System.out.println(this.reverse(x));
    }

    public int reverse(int x) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 1; x != 0; x/=10,  i *= 10){
            stack.push(x%10);
        }
        int result = 0;
        for (int i = 1; stack.size() > 0; i *= 10) {
            try {
                result = Math.addExact(result, Math.multiplyExact(stack.pop(),i));
            } catch (ArithmeticException e) {
                return 0;
            }
        }
        return result;
    }
}
