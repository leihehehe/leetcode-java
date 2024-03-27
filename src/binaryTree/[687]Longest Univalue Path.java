package binaryTree;
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Tree DP
 */

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
    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return res;
    }
    //满足条件的单边最大path
    public int dfs(TreeNode root){
        if(root==null) return -1;
        int left = dfs(root.left);
        int right = dfs(root.right);
        //说明没有path可选，那么left就应该是-1（而不是0），因为这样加上当前节点，才能得到path为0
        if(root.left!=null && root.left.val != root.val){
            left = -1;
        }
        if(root.right!=null && root.right.val!=root.val){
            right = -1;
        }
        res = Math.max(left+right+2,res);
        return Math.max(left,right)+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
