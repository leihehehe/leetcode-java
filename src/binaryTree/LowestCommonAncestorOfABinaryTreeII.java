package binaryTree;

/**
 * Leetcode 1644
 */
public class LowestCommonAncestorOfABinaryTreeII {
    boolean foundP;
    boolean foundQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = findDescendant(root,p.val,q.val);
        if(!foundP || !foundQ){
            return null;
        }
        return res;
    }

    public TreeNode findDescendant(TreeNode root, int val1, int val2){
        if(root==null) return null;
        TreeNode left = findDescendant(root.left,val1,val2);
        TreeNode right = findDescendant(root.right, val1, val2);
        if(left!=null && right!=null) return root;
        if(root.val == val1 || root.val == val2){
            if(root.val == val1) foundP =true;
            if(root.val == val2) foundQ = true;
            return root;
        }
        return left!=null?left:right;
    }
}
