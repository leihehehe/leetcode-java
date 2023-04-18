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
class FindNearestRightNodeInBinaryTree {
    /**
     * Method 1: dfs -> try to find the next traversed node with the same depth
     * @param root
     * @param u
     * @return
     */
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        traverse(root,u,1);
        return nearestNode;
    }
    int targetDepth = -1;
    TreeNode nearestNode=null;
    public void traverse(TreeNode root,TreeNode u,int depth){
        if(root==null || nearestNode!=null) return;
        if(targetDepth==depth){
            nearestNode=root;
            return;
        }
        if(targetDepth==-1 && root==u){
            targetDepth=depth;
        }
        traverse(root.left,u,depth+1);
        traverse(root.right,u,depth+1);
    }

    /**
     * Method 2: bfs level order traversal
     * @param root
     * @param u
     * @return
     */
    public TreeNode findNearestRightNodeMethod2(TreeNode root, TreeNode u) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(queue.size()>0){
            int size = queue.size();
            boolean next = false;
            for(int i = 0;i<size;i++){
                TreeNode cur = queue.poll();
                if(next) return cur;
                if(cur==u) next = true;
                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
