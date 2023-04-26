package binaryTree;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class MinimumDepthOfBinaryTree {
    /**
     * Method 1: bfs-> find the shortest path to the end(leaf node with the min depth)
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        return bfs(root);
    }
    public int bfs(TreeNode root){
        if(root==null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int depth = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0;i<size;i++){
                TreeNode curNode = queue.poll();
                //using dfs allows us to traverse the neighbors of a node
                //in this case, we can return the first come-up leaf node
                if(curNode.left==null && curNode.right==null) return depth;
                if(curNode.left!=null) queue.offer(curNode.left);
                if(curNode.right!=null) queue.offer(curNode.right);
            }
            depth++;
        }
        return depth;
    }
    /**
     * Method 2: dfs
     * Time complexity: O(n)
     * Space complexity: O(n)
     * @param root
     * @return
     */
    int res = Integer.MAX_VALUE;
    public int minDepthMethod2(TreeNode root) {
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
}
//leetcode submit region end(Prohibit modification and deletion)
