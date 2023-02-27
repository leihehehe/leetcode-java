package binaryTree;

/**
 * Leetcode 129
 */
public class SumRootToLeafNumbers {
    /**
     * Time complexity O(N)
     * Space complexity O(N)
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }
    public int dfs(TreeNode root,int sum){
        if(root == null) return 0;
        sum=sum*10+root.val;
        if(root.left==null &&root.right==null) return sum;
        return dfs(root.left,sum)+dfs(root.right,sum);
    }
}
