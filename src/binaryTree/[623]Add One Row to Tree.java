package binaryTree;
//leetcode submit region begin(Prohibit modification and deletion)


import binaryTree.TreeNode;

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
class AddOneRowToTree {
    private int curDepth=0;
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode newNode = new TreeNode(val);
            newNode.left=root;
            return newNode;
        }
        traverse(root,val,depth);
        return root;
    }
    public void traverse(TreeNode root, int val, int depth){
        if(root==null) return;
        curDepth++;
        if(curDepth==depth-1){
            TreeNode newNodeLeft = new TreeNode(val);
            TreeNode newNodeRight = new TreeNode(val);
            TreeNode originalNodeLeft = root.left;
            TreeNode originalNodeRight = root.right;
            newNodeLeft.left=originalNodeLeft;
            newNodeRight.right=originalNodeRight;
            root.left=newNodeLeft;
            root.right=newNodeRight;
        }

        traverse(root.left,val,depth);
        traverse(root.right,val,depth);
        curDepth--;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
