package binaryTree;//leetcode submit region begin(Prohibit modification and deletion)

//import binaryTree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class LargestBSTSubtree {
    class Result{
        int size;
        boolean isBST;
        int maxVal;
        int minVal;
        public Result(int size, boolean isBST, int maxVal, int minVal){
            this.size=size;
            this.isBST = isBST;
            this.maxVal = maxVal;
            this.minVal = minVal;
        }
    }
    private int count = 0;
    public int largestBSTSubtree(TreeNode root) {
        traverse(root);
        return count;
    }
    public Result traverse(TreeNode root){
        if(root==null){
            return new Result(0,true,Integer.MIN_VALUE,Integer.MAX_VALUE);
        }
        Result left = traverse(root.left);
        Result right = traverse(root.right);
        if(left.isBST && right.isBST && left.maxVal<root.val && right.minVal>root.val){
            count = Math.max(count,left.size+ right.size+1);
            return new Result(left.size+ right.size+1, true,Math.max(root.val, right.maxVal),Math.min(root.val,left.minVal));
        }
        return new Result(0,false,0,0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
