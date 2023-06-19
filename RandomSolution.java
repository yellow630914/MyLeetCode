import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomSolution {
    @Test
    public void testSolution(){
        int[] nums = {1,2,3};
        Solution solution = new Solution(nums);
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.reset()));
        System.out.println(Arrays.toString(solution.shuffle()));
    }
}

class Solution{
    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int length = this.nums.length;
        int[] rNums = this.nums.clone();
        for (int i = 0; i < length; i++) {
            int rIndex = Math.abs(this.random.nextInt() % length);
            rNums = this.swap(rNums,i,rIndex);
        }
        return rNums;
    }

    private int[] swap(int[] nums,int ori,int target){
        int[] result = nums;
        int temp = result[ori];
        result[ori] = result[target];
        result[target] = temp;
        return result;
    }
}
