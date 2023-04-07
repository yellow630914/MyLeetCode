import org.junit.jupiter.api.Test;

public class LongestCommonPrefix {
    @Test
    public void testLongestCommonPrefix(){
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs){
        StringBuffer result = new StringBuffer();
        char target = 0;
        if (strs.length > 0 && strs[0].length() > 0) {
            target = strs[0].charAt(0);
        }
        for (int i = 0; i < 200; i++) {
            try {
                for (int j = 0; j < strs.length; j++) {
                    if(target != strs[j].charAt(i)){
                        return result.toString();
                    }
                }
                result.append(target);
                target = strs[0].charAt(i + 1);
            } catch (Exception e) {
                return result.toString();
            }
        }
        return result.toString();
    }
}
