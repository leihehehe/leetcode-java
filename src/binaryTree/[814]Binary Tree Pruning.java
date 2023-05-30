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
class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        return remove(root);
    }

    public TreeNode remove(TreeNode root){
        if(root==null) return null;
        TreeNode left = remove(root.left);
        TreeNode right = remove(root.right);
        root.left = left;
        root.right = right;
        if(root.left==null && root.right==null && root.val == 0) return null;
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
