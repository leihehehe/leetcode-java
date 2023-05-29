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
class BinaryTreeTilt {
    private int tiltSum=0;
    public int findTilt(TreeNode root) {
        getSum(root);
        return tiltSum;
    }
    public int getSum(TreeNode root){
        if(root==null) return 0;
        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);
        int tilt = Math.abs(leftSum-rightSum);
        tiltSum+=tilt;
        int curSum = leftSum+rightSum+root.val;
        return curSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
