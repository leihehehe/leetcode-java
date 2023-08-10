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
class BinaryTreeMaximumPathSum {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }
    //当前节点包含在内的路径(但是注意这个路径必须是单边的，不能同时有左子树和右子树)
    //因为这个返回给上层节点的时候，root会把连通左子树和右子树的路径一起返回，这个path是不合法的
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int maxLeft = dfs(root.left);
        int maxRight = dfs(root.right);
        //更新结果
        int curMax = root.val + Math.max(0,maxLeft)+Math.max(0,maxRight);
        res = Math.max(res,curMax);
        //返回结果必须是单边的最大值
        return root.val+Math.max(Math.max(maxLeft,maxRight),0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
