package binaryTree;

/**
 * Leetcode 226
 */
public class InvertBinaryTree {
    /**
     * Method 1: traverse
     * Time complexity: O(N)
     * Space complexity: O(N)
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }
    public void traverse(TreeNode root){
        if(root==null) return;
        TreeNode tmp = root.left;
        root.left=root.right;
        root.right=tmp;
        traverse(root.left);
        traverse(root.right);
    }

    /**
     * Method 2: recursive divide and conquer
     * Time complexity: O(N)
     * Space complexity: O(N)
     * @param root
     * @return
     */
    public TreeNode invertTreeMethod2(TreeNode root) {
        if(root==null) return null;
        TreeNode leftNode = invertTree(root.left);
        TreeNode rightnode = invertTree(root.right);
        root.left = rightnode;
        root.right = leftNode;
        return root;
    }
}
