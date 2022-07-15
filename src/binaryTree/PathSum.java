package binaryTree;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return checkPathSum(root,0,targetSum);
    }

    public boolean checkPathSum(TreeNode node,int sum,int targetSum){
        if(node==null) return false;
        sum+=node.val;
        if(node.left==null && node.right ==null && sum==targetSum) return true;
        return checkPathSum(node.left,sum,targetSum) || checkPathSum(node.right,sum,targetSum);
    }
}
