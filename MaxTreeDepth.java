import org.junit.jupiter.api.Test;

public class MaxTreeDepth {
    @Test
    public void testMaxDepth(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(maxDepth(root));
    }

    /**
     * My Recursion Case
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root){
        int depth;
        int max = 1;
        if (root == null)
            return 0;
        while (root.left != null || root.right != null){
            depth = explore(root);
            if (max < depth)
                max = depth;
        }
        return max;
    }

    public int explore(TreeNode root){
        int depth = 1,temp;
        if (root.left == null && root.right == null){
            return depth;
        }
        if (root.left != null){
            temp = explore(root.left) + 1;
            depth = temp > depth ? temp : depth;
            root.left = null;
        }
        if (root.right != null){
            temp = explore(root.right) + 1;
            depth = temp > depth ? temp : depth;
            root.right = null;
        }
        return depth;
    }

    /**
     * Beautiful Solution
     * @param root
     * @return
     */
    public int maxDepthMoreGrace(TreeNode root){
        return root==null ?
                0 : Math.max(maxDepthMoreGrace(root.left), maxDepthMoreGrace(root.right))+1;
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
