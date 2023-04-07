import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class CountAndSay {
    @Test
    public void testCountAndSay(){
        int i = 5;
        System.out.println(countAndSay(i));
    }

    public String countAndSay(int n){
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = describeNumString(s);
        }
        return s;
    }

    public String describeNumString(String s){
        StringBuffer sb = new StringBuffer();
        char value = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == value){
                count++;
            } else {
                sb.append(count);
                sb.append(value);
                count = 1;
                value = s.charAt(i);
            }
        }
        sb.append(count);
        sb.append(value);
        return sb.toString();
    }
}
