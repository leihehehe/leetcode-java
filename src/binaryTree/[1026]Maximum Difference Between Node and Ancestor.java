package binaryTree;
//leetcode submit region begin(Prohibit modification and deletion)

import binaryTree.TreeNode;

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
class MaxAncestorDiff {
    public int maxAncestorDiff(TreeNode root) {
        dfs(root,root.val,root.val);
        return res;
    }
    int res = 0;
    public void dfs(TreeNode root, int min, int max){
        if(root==null){
            return ;
        }
        min = Math.min(min,root.val);
        max = Math.max(max,root.val);
        res = Math.max(res,max-min);
        dfs(root.left,min,max);
        dfs(root.right,min,max);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
