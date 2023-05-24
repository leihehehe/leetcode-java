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
class RecoverBinarySearchTree {
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    TreeNode first = null, second = null;
    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = first.val;
        first.val=second.val;
        second.val=temp;
    }
    public void traverse(TreeNode root){
        if(root==null) return;
        traverse(root.left);
        if(prev.val>root.val){
            if(first==null) first = prev;
            second = root;
        }
        prev = root;
        traverse(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
