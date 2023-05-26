package binaryTree;
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class IncreasingOrderSearchTree {
    /**
     * Method 1
     * @param root
     * @return
     */
    public TreeNode increasingBST(TreeNode root) {
        return rearrange(root);
    }
    public TreeNode rearrange(TreeNode root){
        if(root==null) return null;

        TreeNode leftNode = rearrange(root.left);
        root.left = null;
        TreeNode rightNode = rearrange(root.right);
        root.right = rightNode;
        if(leftNode==null){
            return root;
        }
        TreeNode p = leftNode;
        while(p!=null && p.right!=null){
            p = p.right;
        }
        p.right = root;
        return leftNode;
    }

    /**
     * Method 2: traverse
     */
    TreeNode dummyNode = new TreeNode(-1);
    TreeNode cur = dummyNode;
    public TreeNode increasingBSTMethod2(TreeNode root) {
        traverse(root);
        return dummyNode.right;
    }

    public void traverse(TreeNode root){
        if(root==null) return;
        traverse(root.left);
        cur.right = new TreeNode(root.val);
        cur = cur.right;
        traverse(root.right);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
