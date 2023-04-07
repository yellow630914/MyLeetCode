import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SortedArrayToBST {
    @Test
    public void testSortedArrayToBST(){
        int[] nums = new int[]{-10,-3,0,5,9};
        sortedArrayToBSTWithBFS(nums);
    }

    /**
     * 遞迴解法，先把中間值取出，將數組分割成兩邊並放入遞迴。
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums){
        TreeNode root = new TreeNode(getMiddleNum(nums));

        this.genBST(root,nums);

        return root;
    }
    private void genBST(TreeNode middle,int[] nums){
        if(nums.length == 0 || middle == null) return;
        int[][] cutArray = cutArrayWithoutMiddle(nums);
        TreeNode left = cutArray[0].length != 0 ? new TreeNode(getMiddleNum(cutArray[0])) : null;
        TreeNode right = cutArray[1].length != 0 ? new TreeNode(getMiddleNum(cutArray[1])) : null;
        middle.left = left;
        middle.right = right;
        genBST(left,cutArray[0]);
        genBST(right,cutArray[1]);
    }

    /**
     * BFS解法，用queue處理
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBSTWithBFS(int[] nums){
        if(nums.length == 0)
            return null;
        Queue<int[]> rangeQueue = new LinkedList<>();
        Queue<TreeNode> treeQueue = new LinkedList<>();
        TreeNode root = new TreeNode(this.getMiddleNum(nums));
        treeQueue.add(root);
        rangeQueue.add(Arrays.copyOfRange(nums,0, nums.length/2));
        rangeQueue.add(Arrays.copyOfRange(nums, nums.length/2 + 1, nums.length));
        while (!treeQueue.isEmpty()) {
            TreeNode node = treeQueue.poll();
            int[] leftArray = rangeQueue.poll();
            int[] rightArray = rangeQueue.poll();
            if (leftArray.length != 0) {
                node.left = new TreeNode(this.getMiddleNum(leftArray));
                treeQueue.add(node.left);
                rangeQueue.add(Arrays.copyOfRange(leftArray,0,leftArray.length/2));
                rangeQueue.add(Arrays.copyOfRange(leftArray,leftArray.length/2 + 1,leftArray.length));
            }
            if (rightArray.length != 0) {
                node.right = new TreeNode(this.getMiddleNum(rightArray));
                treeQueue.add(node.right);
                rangeQueue.add(Arrays.copyOfRange(rightArray,0,rightArray.length/2));
                rangeQueue.add(Arrays.copyOfRange(rightArray,rightArray.length/2 + 1,rightArray.length));
            }
        }
        return root;
    }
    private int getMiddleNum(int[] nums){
        return nums[nums.length/2];
    }
    private int[][] cutArrayWithoutMiddle(int[] nums){
        int[][] result = new int[2][];
        result[0] = Arrays.copyOfRange(nums,0, nums.length/2);
        result[1] = Arrays.copyOfRange(nums, nums.length/2 + 1, nums.length);
        return result;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
