package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {
    int res = Integer.MAX_VALUE;

    /**
     * Method 1: dfs
     * Time complexity: O(n)
     * Space complexity: O(n)
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        dfs(root,0);
        return res+1;
    }
    public void dfs(TreeNode root,int layer){
        if(root==null) return;
        //only record the layer when it is the last layer
        if(root.left==null &&root.right==null)
            res = Math.min(res,layer);
        dfs(root.left,layer+1);
        dfs(root.right,layer+1);
    }

    /**
     * Method 2: bfs
     * Time complexity: O(n)
     * Space complexity: O(n)
     * @param root
     * @return
     */
    public int minDepthMethod2(TreeNode root) {
        if(root==null) return 0;
        bfs(root);
        return res;
    }
    public void bfs(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null) res = Math.min(res, level);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
        }
    }
}
