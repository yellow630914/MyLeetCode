import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
    @Test
    public void testWordBreak(){
        List<String> wordDict = new ArrayList<>();
        wordDict.add("dd");
        wordDict.add("ad");
        wordDict.add("da");
        wordDict.add("b");
        System.out.println(this.wordBreak("ddadddbdddadd", wordDict));
    }

    private boolean wordBreak(String s, List<String> wordDict){
        boolean[][] dp = new boolean[wordDict.size()][s.length()];
        for (int i = 0; i < wordDict.size(); i++) {
            StringBuffer curStr = new StringBuffer("");
            for (int j = 0; j < s.length(); j++) {
                curStr.append(s.charAt(j));
                // 未完
            }
        }
        return false;
    }
}
