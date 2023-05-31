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
class LongestUnivaluePath {
    int maxLen = 0;
    public int longestUnivaluePath(TreeNode root) {
        getPathLen(root);
        return maxLen;
    }

    public int getPathLen(TreeNode root){
        if(root==null) return 0;
        int leftLen = getPathLen(root.left);
        int rightLen = getPathLen(root.right);
        int curLen = 0;
        if(root.left!=null && root.left.val == root.val)
            curLen=leftLen+1;
        if(root.right!=null && root.right.val == root.val)
            curLen=Math.max(curLen,rightLen+1);
        maxLen = Math.max(curLen,maxLen);
        if(root.left!=null && root.right!=null && root.left.val == root.val && root.right.val == root.val){
            maxLen = Math.max(maxLen,leftLen+rightLen+2);
        }
        return curLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
