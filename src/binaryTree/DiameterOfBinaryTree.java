package binaryTree;

/**
 * Leetcode 543
 */
public class DiameterOfBinaryTree {
    private int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getMaxDepth(root);
        return res;
    }
    public int getMaxDepth(TreeNode root){
        if(root==null) return 0;
        int l = getMaxDepth(root.left);
        int r = getMaxDepth(root.right);
        int diameter = l+r;
        res = Math.max(diameter,res);
        return 1+Math.max(l,r);
    }
}
