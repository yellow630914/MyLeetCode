import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class GreatestCommonFactor {
    @Test
    public void testGreatestCommonFactor(){

        int n1 = 65;
        int n2 = 130;
        int n3 = 250;
        System.out.println(this.getGreatestCommonFactor(n1, n2, n3));
        System.out.println(this.anotherGreatestCommonFactor(n1, n2, n3));

        String s1 = "landon";
        String s2 = "abandon";
        System.out.println(this.commonStr(s1, s2));

    }

    private int getGreatestCommonFactor(int n1,int n2,int n3){
        int result = 1;
        int cFactor = 2;
        while (cFactor <= Math.min(n1,Math.min(n2,n3))){
            if (n1 % cFactor == 0 && n2 % cFactor == 0 && n3 % cFactor == 0){
                result = cFactor;
            }
            cFactor++;
        }
        return result;
    }

    private int anotherGreatestCommonFactor(int n1,int n2,int n3){
        int[] ns = {n1,n2,n3};
        Arrays.sort(ns);
        return this.getGCD(this.getGCD(ns[2],ns[0]),this.getGCD(ns[2],ns[1]));
    }

    private int getGCD(int max,int min){
        if (max % min == 0){
            return min;
        }
        int temp = min;
        min = max % min;
        max = temp;
        return getGCD(max,min);
    }

    private String commonStr(String s1,String s2){
        for (int range = s2.length(); range > 0; range--) {
            for (int j = 0; j <= s2.length() - range; j++) {
                String rangeStr = s2.substring(j,j+range);
                if (s1.contains(rangeStr)){
                    return rangeStr;
                }
            }
        }
        return "";
    }




}
