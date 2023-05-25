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
class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return isPathSum(root,targetSum,0);
    }
    public boolean isPathSum(TreeNode root, int targetSum,int curSum){
        if(root==null){
            return false;
        }
        curSum+=root.val;
        if(root.left==null && root.right ==null&& curSum==targetSum){
            return true;
        }
        return isPathSum(root.left,targetSum,curSum) || isPathSum(root.right,targetSum,curSum);
    }

    /**
     * traverse
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSumMethod2(TreeNode root, int targetSum) {
        traverse(root,targetSum);
        return found;
    }
    int sum = 0;
    boolean found = false;
    public void traverse(TreeNode root,int targetSum){
        if(found || root==null){
            return;
        }
        sum+=root.val;
        if(root.left ==null && root.right==null && sum ==targetSum){
            found = true;
            return;
        }

        traverse(root.left,targetSum);
        traverse(root.right,targetSum);
        sum-=root.val;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
