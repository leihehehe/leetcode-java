package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/***
 * Leetcode 104
 */
class MaximumDepthOfBinaryTree {
    int maxDepth=0;
    public int maxDepth(TreeNode root) {
        traverseTree(root,0);
        return maxDepth;
    }

    public void traverseTree(TreeNode root, int depth){
        if(root==null){
            return;
        }
        maxDepth=Math.max(depth,maxDepth);
        traverseTree(root.left,depth+1);
        traverseTree(root.right,depth+1);
    }

    /***
     * Recursion from bottom to top (get the results of sub nodes)
     * @param root
     * @return
     */
    public int maxDepthMethod2(TreeNode root) {
        return recursiveDepth(root);
    }
    public int recursiveDepth(TreeNode node){
        if(node==null) return 0;
        int leftDepth = recursiveDepth(node.left);
        int rightDepth = recursiveDepth(node.right);
        return Math.max(leftDepth,rightDepth)+1;

    }

    public int maxDepthMethod3(TreeNode root){
        if(root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            depth++;
            for(int i = 0;i<size;i++){
                TreeNode cur = queue.poll();
                if(cur.left!=null)
                    queue.offer(cur.left);
                if(cur.right!=null)
                    queue.offer(cur.right);
            }
        }
        return depth;
    }
}
