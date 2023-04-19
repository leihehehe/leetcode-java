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
class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        traverse(root,1);
        return res;
    }
    int maxDepth = -1;
    int res = 0;
    public void traverse(TreeNode root, int depth){
        if(root==null) return;
        if(maxDepth<depth){
            maxDepth=depth;
            res = root.val;
        }
        traverse(root.left,depth+1);
        traverse(root.right,depth+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
