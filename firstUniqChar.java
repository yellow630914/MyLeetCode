import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class firstUniqChar {
    @Test
    public void testFirstUniqChar(){
        String s = "loveleetcode";
        System.out.println(this.firstUniqCharHashMap(s));
    }

    /**
     * mine
     * @param s
     * @return
     */
    private int firstUniqChar(String s){
        Set<Character> chars = new HashSet<>();
        for(int i = 0;i < s.length();i++){
            boolean flag = true;
            if(chars.contains(s.charAt(i))){
                continue;
            }
            for (int j = i + 1; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)){
                    flag = false;
                    chars.add(s.charAt(i));
                    break;
                }
            }
            if (flag) return i;
        }
        return -1;
    }

    /**
     * 用hashMap解
     * @param s
     * @return
     */
    private int firstUniqCharHashMap(String s){
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}
