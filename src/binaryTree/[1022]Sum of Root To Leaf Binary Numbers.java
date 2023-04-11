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
class SumOfRootToLeafBinaryNumbers {
    private int sum;
    private StringBuilder path = new StringBuilder();
    public int sumRootToLeaf(TreeNode root) {
        traverse(root);
        return sum;
    }
    public void traverse(TreeNode root){
        if(root==null) return;
        path.append(root.val);
        if(root.left==null && root.right==null){
            sum+=Integer.valueOf(path.toString(),2);
            path.deleteCharAt(path.length()-1);
            return;
        }
        traverse(root.left);
        traverse(root.right);
        path.deleteCharAt(path.length()-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
