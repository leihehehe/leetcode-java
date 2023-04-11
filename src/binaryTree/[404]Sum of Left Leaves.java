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
class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        traverse(root,false);
        return res;
    }
    private int res = 0;
    public void traverse(TreeNode root, boolean left){
        if(root==null) return;
        if(root.left==null && root.right==null){
            if(left) res+=root.val;
            return;
        }
        traverse(root.left,true);
        traverse(root.right,false);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
