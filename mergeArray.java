import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class mergeArray {
    @Test
    public void testMerge(){
        int[] a = {-1,0,0,3,3,3,0,0,0};
        int[] b = {1,2,2};
        mergeAnother(a,6,b,3);
        System.out.println(a);
    }

    /**
     * 我是傻逼
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0,j = 0; i < nums1.length; i++) {
            if (i >= m && nums1[i] == 0) {
                int temp;
                temp = nums2[j];
                nums1[i] = nums2[j];
                nums2[j] = temp;
                j++;
            }
            if (j != n && nums1[i] >= nums2[j]) {
                int temp;
                temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
                Arrays.sort(nums2);
            }
        }
    }

    /**
     * 從後面來
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void mergeAnother(int[] nums1, int m, int[] nums2, int n){
        int i = m - 1;
        int j = n - 1;
        int end = m + n - 1;
        while (j >= 0) {
            nums1[end--] = (i >= 0 && nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
        }
    }
}
