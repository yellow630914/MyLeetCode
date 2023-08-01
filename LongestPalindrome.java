import org.junit.jupiter.api.Test;

public class LongestPalindrome {
    @Test
    public void testLongestPalindrome(){
        String str = "intenety";
        System.out.println(this.longestPalindrome(str));
    }

    private String longestPalindrome(String s){
        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        int maxStart = 0;  //最常回文串的起點
        int maxEnd = 0;    //最常回文串的終點
        int maxLen = 1;  //最常回文串的長度

        // 儲存狀態的Array[l][r]
        boolean[][] dp = new boolean[strLen][strLen];

        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                // l是左指針，r是右指針，先對比兩字符是否相等。後確認這兩個字符分得夠開，或是兩字的內側是回文字串
                // dp[l + 1][r - 1]記錄著l與r中間的字串是否為回文字串
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    // 當確認是回文字串後，確保其長度是最長的，如果是替換掉之前紀錄的指針
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }
}
