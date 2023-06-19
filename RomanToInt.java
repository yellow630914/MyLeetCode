import org.junit.jupiter.api.Test;

public class RomanToInt {
    @Test
    public void testRomanToInt(){
        String s = "LVIII";
        System.out.println(romanToInt(s));
    }

    public int romanToInt(String s){
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)){
                case 'M':
                    num += 1000;
                    break;
                case 'D':
                    num += 500;
                    break;
                case 'C':
                    if (i + 1 != s.length() && (s.charAt(i+1) == 'M' || s.charAt(i+1) == 'D')) {
                        num -= 100;
                    } else {
                        num += 100;
                    }
                    break;
                case 'L':
                    num += 50;
                    break;
                case 'X':
                    if (i + 1 != s.length() && (s.charAt(i+1) == 'C' || s.charAt(i+1) == 'L')) {
                        num -= 10;
                    } else {
                        num += 10;
                    }
                    break;
                case 'V':
                    num += 5;
                    break;
                case 'I':
                    if (i + 1 != s.length() && (s.charAt(i+1) == 'X' || s.charAt(i+1) == 'V')) {
                        num -= 1;
                    } else {
                        num += 1;
                    }
                    break;
            }
        }
        return num;
    }

}
