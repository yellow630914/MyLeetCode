import org.junit.jupiter.api.Test;

public class IsValidBST {
    @Test
    public void testIsValidBST(){
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(6);
        System.out.println(isValidBST(root));
    }

    public boolean isValidBST(TreeNode root){
        return isBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean isBST(TreeNode root,long min,long max){
        if (root == null)
            return true;

        if (root.val <= min || root.val >= max)
            return false;

        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
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
