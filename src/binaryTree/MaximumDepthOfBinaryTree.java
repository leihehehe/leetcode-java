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
}
