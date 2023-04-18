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
class SumOfNodesWithEvenValuedGrandparent {
    private int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        traverse(root,null,null);
        return sum;
    }
    public void traverse(TreeNode root, TreeNode parent, TreeNode grandNode){
        if(root==null) return;
        if(grandNode!=null && grandNode.val%2==0) sum+=root.val;
        traverse(root.left,root,parent);
        traverse(root.right,root,parent);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
