package binaryTree;
//leetcode submit region begin(Prohibit modification and deletion)
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
class CousinsInBinaryTree {
    private int depth=0;
    private int depthX=-1;
    private int depthY=-1;
    private TreeNode parentX;
    private TreeNode parentY;
    public boolean isCousins(TreeNode root, int x, int y) {
        traverse(root,x,y,null);
        if(parentY!=parentX && depthX==depthY) return true;
        return false;
    }
    public void traverse(TreeNode root, int x, int y, TreeNode parent){
        if(root==null) return;
        depth++;
        if(root.val==x){
            depthX=depth;
            parentX=parent;
        }
        if(root.val==y){
            depthY=depth;
            parentY=parent;
        }
        traverse(root.left,x,y,root);
        traverse(root.right,x,y,root);
        depth--;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
