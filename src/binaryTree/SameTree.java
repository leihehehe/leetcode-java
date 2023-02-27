package binaryTree;

/**
 * Leetcode 100
 */
public class SameTree {
    /**
     * Time complexity: O(min(m,n))
     * Space complexity: O(min(m,n))
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p,q);
    }
    public boolean dfs(TreeNode p, TreeNode q){
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val!=q.val) return false;
        return dfs(p.left,q.left) && dfs(p.right,q.right);
    }
}
