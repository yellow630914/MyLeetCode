import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyAtoi {
    @Test
    public void testMyAtoi(){
        String s = "words and 987";
        System.out.println(this.myAtoi(s));
    }

    public int myAtoi(String s){
        s = s.trim();
        char[] chars = s.toCharArray();
        int factor = 1;
        int result = 0;
        int i = 0;

        if(chars.length > 0 && isNum(chars[0])){
            if (chars[0] == '-' || chars[0] == '+'){
                factor = chars[0] == '-' ? -1 : 1;
                i++;
            }
        } else {
            return result;
        }


        for (; i < chars.length; i++) {
            if(chars[i] >= '0' && chars[i] <= '9'){
                if (result < Integer.MAX_VALUE/10 ||
                        (result == Integer.MAX_VALUE/10 && Character.getNumericValue(chars[i]) <= 7)) {
                    result = result*10 + Character.getNumericValue(chars[i]);
                } else {
                    return factor == 1 ? Integer.MAX_VALUE:Integer.MIN_VALUE;
                }
            } else {
                break;
            }
        }
        return result * factor;

    }

    private boolean isNum(char c){
        if(c >= '0' && c <= '9'){
            return true;
        }
        if(c == '+' || c == '-'){
            return true;
        }
        return false;
    }
}
