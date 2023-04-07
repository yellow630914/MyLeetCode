import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    @Test
    public void testLevelOrder(){

    }

    /**
     * 遞迴解法
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> treeList = new ArrayList<>();
        int depth = 0;
        this.getDepthList(treeList,root,depth);
        return treeList;
    }

    public void getDepthList(List<List<Integer>> treeList,TreeNode node,int depth){
        // 判斷邊界
        if (node == null)
            return;
        // 當深度往下時，List的元素也要增加。
        if (depth >= treeList.size())
            treeList.add(new ArrayList<>());
        // 依照深度將值填入對應元素
        treeList.get(depth).add(node.val);
        // 繼續往下走
        getDepthList(treeList,node.left,depth + 1);
        getDepthList(treeList,node.right,depth + 1);
    }

    /**
     * BFS Case
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderWithBFS(TreeNode root){
        // 邊界判斷
        if (root == null)
            return new ArrayList<>();
        // 暫存隊列
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        // 先將root放入隊列
        queue.add(root);
        // 當隊列為空的時候，停止循環。
        while (!queue.isEmpty()){
            // 依照上一輪的紀錄，從隊列的數量取得此深度的元素數量。
            int depthNodeNum = queue.size();
            // 建立此輪深度的清單。
            List<Integer> currDepthList = new ArrayList<>();
            // 將此輪的元素遍歷。
            for (int i = 0; i < depthNodeNum; i++) {
                // 將queue最先的元素poll出去。
                TreeNode currNode = queue.poll();
                // 將此元素的值加入清單。
                currDepthList.add(currNode.val);
                // 將下一輪的元素加入queue中。
                if (currNode.left != null)
                    queue.add(currNode.left);
                if (currNode.right != null)
                    queue.add(currNode.right);
            }
            result.add(currDepthList);
        }
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
