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
class BinaryTreeLongestConsecutiveSequenceII {
    private int maxLen = 0;
    class Result{
        int increasingPathLen;
        int decreasingPathLen;
        public Result(int increasingPathLen, int decreasingPathLen){
            this.increasingPathLen = increasingPathLen;
            this.decreasingPathLen = decreasingPathLen;
        }
    }
    public int longestConsecutive(TreeNode root) {
        getPathLen(root);
        return maxLen;
    }
    public Result getPathLen(TreeNode root){
        if(root==null) return new Result(0,0);
        Result leftRes = getPathLen(root.left);
        Result rightRes = getPathLen(root.right);
        int curIncreasingPathLen = 1;
        int curDecreasingPathLen = 1;
        if(root.left!=null){
            //decreasing
            if(root.val - root.left.val ==1){
                curDecreasingPathLen = leftRes.decreasingPathLen+1;
            }else if(root.left.val-root.val == 1){
                curIncreasingPathLen = leftRes.increasingPathLen+1;
            }
        }
        if(root.right!=null){
            if(root.val - root.right.val ==1){
                curDecreasingPathLen = Math.max(curDecreasingPathLen,rightRes.decreasingPathLen+1);
            }else if(root.right.val-root.val == 1){
                curIncreasingPathLen = Math.max(curIncreasingPathLen,rightRes.increasingPathLen+1);
            }
        }
        maxLen = Math.max(maxLen,curIncreasingPathLen+curDecreasingPathLen-1);
        return new Result(curIncreasingPathLen,curDecreasingPathLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
