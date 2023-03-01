package binaryTree;

/**
 * Leetcode 98
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class ValidateBinarySearchTree {
    Integer pre;
    public boolean isValidBST(TreeNode root) {
        return traverse(root);
    }


    public boolean traverse(TreeNode root){
        if(root==null) return true;
        boolean leftValid = traverse(root.left);
        if(pre!=null && root.val<=pre) return false;
        pre = root.val;
        boolean rightValid = traverse(root.right);
        return leftValid&&rightValid;
    }
}
