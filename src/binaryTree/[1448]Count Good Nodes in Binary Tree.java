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
class CountGoodNodesInBinaryTree {
    private int count = 0;
    public int goodNodes(TreeNode root) {
        traverse(root, Integer.MIN_VALUE);
        return count;
    }
    public void traverse(TreeNode root,int maxLen){
        if(root==null) return;
        if(root.val>=maxLen){
            maxLen = root.val;
            count++;
        }
        traverse(root.left,maxLen);
        traverse(root.right,maxLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
