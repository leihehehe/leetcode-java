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
class Solution {

    public int longestConsecutive(TreeNode root) {
        traverse(root,Integer.MAX_VALUE,0);
        return maxLen;
    }
    private int maxLen = 0;
    public void traverse(TreeNode root, int parentValue,int curLen){
        if(root==null) return;
        if(parentValue+1==root.val) curLen+=1;
        else curLen=1;
        maxLen = Math.max(maxLen,curLen);
        traverse(root.left,root.val,curLen);
        traverse(root.right,root.val,curLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
