package binaryTree;
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class isSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null || B ==null) return false;
        if(isSubTree(A,B)) return true;
        return isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }
    public boolean isSubTree(TreeNode A, TreeNode B){
        if(B==null) return true;
        if(A==null && B!=null) return false;
        if(A.val!=B.val) return false;
        return isSubTree(A.left,B.left) && isSubTree(A.right,B.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
