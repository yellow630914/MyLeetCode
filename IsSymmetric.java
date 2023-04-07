import org.junit.jupiter.api.Test;

public class IsSymmetric {
    @Test
    public void testIsSymmetric(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        System.out.println(isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root){
        return isSame(root.left,root.right);
    }

    public boolean isSame(TreeNode left,TreeNode right){
        if (left == null && right == null)
            return true;
        if (left == null || right == null || right.val != left.val)
            return false;
        return isSame(left.left,right.right) && isSame(left.right,right.left);
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
