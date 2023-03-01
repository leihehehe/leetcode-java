package binaryTree;

/**
 * Leetcode 701
 */
public class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return traverse(root,val);
    }
    public TreeNode traverse(TreeNode root,int val){
        if(root==null) return new TreeNode(val);
        if(val<root.val) root.left = traverse(root.left,val);
        if(val>root.val) root.right= traverse(root.right,val);
        return root;
    }
}
