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
class RangeSumOfBST {
    private int low;
    private int high;
    private int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;
        traverse(root);
        return sum;
    }

    public void traverse(TreeNode root){
        if(root==null) return;
        if(root.val>=low && root.val <=high){
            sum+=root.val;
        }
        traverse(root.left);
        traverse(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
