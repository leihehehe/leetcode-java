package binaryTree;

/***
 * Leetcode 101: Symmetric Tree
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return checkIfSymmetric(root.left, root.right);
    }
    public boolean checkIfSymmetric(TreeNode leftNode, TreeNode rightNode){
        if(leftNode == null && rightNode == null) return true;
        if(leftNode ==null || rightNode == null) return false;
        if(leftNode.val != rightNode.val) return false;
        return checkIfSymmetric(leftNode.left, rightNode.right) && checkIfSymmetric(leftNode.right,rightNode.left);
    }
}
