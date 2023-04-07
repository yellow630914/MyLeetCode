import org.junit.jupiter.api.Test;

public class isPalindrome {
    @Test
    public void testIsPalindrome(){
        String s = "0P";
        System.out.println(isPalindrome(s));
    }

    public boolean isPalindrome(String s){
        s = s.trim().toLowerCase();
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            if (!isLetter(chars[left])){
                left++;
                continue;
            }
            if (!isLetter(chars[right])){
                right--;
                continue;
            }
            if(chars[left] != chars[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isLetter(char c){
        if(c >= 'a' && c <= 'z'){
            return true;
        }
        if(c >= '0' && c <= '9'){
            return true;
        }
        return false;
    }
}
