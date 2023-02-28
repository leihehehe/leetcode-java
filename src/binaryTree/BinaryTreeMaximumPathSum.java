package binaryTree;

/**
 * Leetcode 124
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
public class BinaryTreeMaximumPathSum {
    private int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        getOneSideMax(root);
        return sum;
    }
    public int getOneSideMax(TreeNode root){
        if(root==null) return 0;
        int l =Math.max(getOneSideMax(root.left),0);
        int r = Math.max(getOneSideMax(root.right),0);
        int pathSum =l+r+root.val;
        sum = Math.max(pathSum,sum);
        return root.val+Math.max(l,r);
    }
}
