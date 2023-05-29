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
class DeleteLeavesWithAGivenValue {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        TreeNode finalNode = traverse(root,target);
        if(finalNode!=null && finalNode.left==null && finalNode.right==null && finalNode.val==target)
            return null;
        return finalNode;
    }

    public TreeNode traverse(TreeNode root, int target){
        if(root==null) return null;
        TreeNode leftNode = traverse(root.left, target);
        TreeNode rightNode = traverse(root.right, target);
        if(leftNode!=null && leftNode.left==null && leftNode.right==null && leftNode.val==target)
            root.left=null;
        if(rightNode!=null && rightNode.left==null && rightNode.right==null && rightNode.val==target)
            root.right=null;
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
