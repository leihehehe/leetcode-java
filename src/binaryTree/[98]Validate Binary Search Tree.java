package binaryTree;

/**
 * Leetcode 98
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class ValidateBinarySearchTree {
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

    /**
     * Method 2: recursive
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        return isValid2(root,null,null);
    }
    public boolean isValid2(TreeNode root, TreeNode smallerThan, TreeNode greaterThan){
        if(root==null){
            return true;
        }

        if(smallerThan!=null && root.val>=smallerThan.val){
            return false;
        }
        if(greaterThan!=null && root.val<=greaterThan.val){
            return false;
        }
        return isValid2(root.left,root,greaterThan) && isValid2(root.right,smallerThan,root);
    }
}
