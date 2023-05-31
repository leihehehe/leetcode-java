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
class SmallestSubtreeWithAllTheDeepestNodes {
    class Result{
        TreeNode nearestNode;
        int depth;
        public Result(TreeNode nearestNode, int depth){
            this.nearestNode = nearestNode;
            this.depth=depth;
        }
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return getDepth(root).nearestNode;
    }

    public Result getDepth(TreeNode root){
        if(root==null) return new Result(null, 0);
        Result leftRes = getDepth(root.left);
        Result rightRes = getDepth(root.right);
        if(leftRes.depth == rightRes.depth) return new Result(root,leftRes.depth+1);
        if(leftRes.depth>rightRes.depth){
            return new Result(leftRes.nearestNode,leftRes.depth+1);
        }
        else{
            return new Result(rightRes.nearestNode,rightRes.depth+1);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
