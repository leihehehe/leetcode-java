package binaryTree;

/**
 * Leetcode 112
 */
public class PathSum {
    /**
     * Method 1
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return checkPathSum(root,0,targetSum);
    }

    public boolean checkPathSum(TreeNode node,int sum,int targetSum){
        if(node==null) return false;
        sum+=node.val;
        if(node.left==null && node.right ==null && sum==targetSum) return true;
        return checkPathSum(node.left,sum,targetSum) || checkPathSum(node.right,sum,targetSum);
    }

    /**
     * Method2
     */

    int targetSum=0;
    boolean res = false;
    public boolean hasPathSumMethod2(TreeNode root, int targetSum) {
        if(root==null) return res;
        this.targetSum=targetSum;
        dfs(root,0);
        return res;
    }
    public void dfs(TreeNode root,int sum){
        if(root==null) return;
        sum+=root.val;
        if(sum==targetSum && root.left==null && root.right==null){
            res= true;
            return;
        }
        dfs(root.left,sum);
        dfs(root.right,sum);
    }
}
