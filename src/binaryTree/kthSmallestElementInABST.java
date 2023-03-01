package binaryTree;

/**
 * Leetcode 230
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
public class kthSmallestElementInABST {
    private int target;
    private int curLevel;
    private int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        target=k;
        traverse(root);
        return res;
    }
    public void traverse(TreeNode root){
        if(root==null) return;
        traverse(root.left);
        curLevel++;
        if(curLevel==target) res = root.val;
        traverse(root.right);
    }
}
