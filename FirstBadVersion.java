import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Random;

public class FirstBadVersion {
    @Test
    public void testFirstBadVersion(){
        int n = 2126753390;
        System.out.println(firstBadVersion(n));
    }

    /**
     *
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int head = 1;
        int tail = n;
        if (isBadVersion(head))
            return head;
        while (tail - head > 1) {
            int target = (head - tail) / 2 + tail;
            if (isBadVersion(target)) {
                tail = target;
            } else {
                head = target;
            }
        }
        return tail;
    }

    boolean isBadVersion(int n){
        return n > 1702766718;
    }
}
