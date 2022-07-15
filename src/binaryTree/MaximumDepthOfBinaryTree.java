package binaryTree;

/***
 * Leetcode 104
 */
public class MaximumDepthOfBinaryTree {
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
}
