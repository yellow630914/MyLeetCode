import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class isAnagram {
    @Test
    public void testIsAnagram(){
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagramWithHashMap(s,t));
    }

    /**
     * Array Solution(not for unicode)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagramWithArray(String s, String t){
        int n = s.length();
        if(n != t.length()){
            return false;
        }
        char[] chas = s.toCharArray();
        char[] chat = t.toCharArray();
        int[] arys = new int[26];
        int[] aryt = new int[26];

        for (int i = 0;i < n;i++){
            arys[chas[i] - 'a']++;
            aryt[chat[i] - 'a']++;
        }
        for (int i = 0;i < 26;i++){
            if(arys[i] != aryt[i]){
                return false;
            }
        }
        return true;
    }

    /**
     * HashMap Solution(for unicode)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagramWithHashMap(String s,String t){
        int n = s.length();
        if(n != t.length()){
            return false;
        }
        char[] chas = s.toCharArray();
        char[] chat = t.toCharArray();
        Map<Character,Integer> sMap = new HashMap<>();
        Map<Character,Integer> tMap = new HashMap<>();

        for (int i = 0;i < n;i++){
            sMap.put(chas[i],sMap.getOrDefault(chas[i],0)+1);
            tMap.put(chat[i], tMap.getOrDefault(chat[i],0)+1);
        }
        for (int i = 0;i < sMap.size();i++){
            if(!sMap.get(chas[i]).equals(tMap.get(chas[i]))){
                return false;
            }
        }
        return true;
    }
}
