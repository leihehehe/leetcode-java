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
class RangeSumBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }

    public int dfs(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if(root.val<low){
            return dfs(root.right, low, high);
        }
        if(root.val>high){
            return dfs(root.left, low, high);
        }
        return root.val+ dfs(root.left, low, high) + dfs(root.right, low, high);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
