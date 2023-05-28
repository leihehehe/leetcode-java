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
class CountUnivalueSubtrees {
    private int count;
    public int countUnivalSubtrees(TreeNode root) {
        isUniTree(root);
        return count;
    }
    public boolean isUniTree(TreeNode root){
        if(root==null) return true;
        boolean left = isUniTree(root.left);
        boolean right = isUniTree(root.right);
        if(left&&right){
            if(root.left!=null && root.left.val!=root.val)
                return false;
            if(root.right!=null && root.right.val!=root.val)
                return false;
            count++;
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
