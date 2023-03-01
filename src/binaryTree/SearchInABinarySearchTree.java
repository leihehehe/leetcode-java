package binaryTree;

/**
 * Leetcode 700
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
public class SearchInABinarySearchTree {
    TreeNode res;
    public TreeNode searchBST(TreeNode root, int val) {
        traverse(root,val);
        return res;
    }
    public void traverse(TreeNode root, int val){
        if(root==null) return;
        if(val<root.val) traverse(root.left,val);
        if(root.val==val) res =root;
        if(val>root.val) traverse(root.right,val);
    }
}
