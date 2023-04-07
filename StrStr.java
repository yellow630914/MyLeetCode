import org.junit.jupiter.api.Test;

public class StrStr {
    @Test
    public void testStrStr(){
        String h = "a";
        String n = "a";
        System.out.println(strStr(h,n));
    }

    /**
     * My Case
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack,String needle){
        char[] hChars = haystack.toCharArray();
        char[] nChars = needle.toCharArray();
        if (hChars.length < nChars.length){
            return -1;
        }
        for (int i = 0; i <= hChars.length - nChars.length; i++) {
            if(hChars[i] == nChars[0]){
                boolean flag = true;
                for (int j = 1; j < nChars.length; j++) {
                    if(hChars[i+j] != nChars[j]){
                        flag = false;
                        break;
                    }
                }
                if(flag) {return i;}
            }
        }
        return -1;
    }

}
