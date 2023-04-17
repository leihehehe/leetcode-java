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
class MinimumAbsoluteDifferenceInBST {
    TreeNode pre = null;
    int res = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return res;
    }
    public void traverse(TreeNode root){
        if(root==null) return;
        traverse(root.left);
        if(pre!=null){
            res = Math.min(res,root.val-pre.val);
        }
        pre = root;
        traverse(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
