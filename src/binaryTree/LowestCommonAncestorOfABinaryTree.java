package binaryTree;

/**
 * Leetcode 236
 */
public class LowestCommonAncestorOfABinaryTree {
    /**
     * Time Complexity: O(N)
     * Space Complexity: O(N) => the worst case: a chain
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findDescendant(root,p.val,q.val);
    }
    public TreeNode findDescendant(TreeNode root, int val1, int val2){
        if(root==null) return null;
        //if itself is one of the descendants
        if(root.val==val1 || root.val == val2) return root;
        TreeNode left = findDescendant(root.left,val1,val2);
        TreeNode right = findDescendant(root.right,val1,val2);
        if(left!=null && right!=null){
            return root;
        }
        //p and q may be in the same subtree
        return left!=null?left:right;
    }
}
