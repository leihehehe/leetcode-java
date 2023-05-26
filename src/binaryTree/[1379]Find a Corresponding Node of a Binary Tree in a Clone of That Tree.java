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

class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {
    private TreeNode res;

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        traverse(original,cloned,target);
        return res;
    }

    public void traverse(TreeNode original, TreeNode cloned, TreeNode target){
        if(original==null || res!=null){
            return;
        }
        if(target==original){
            res = cloned;
            return;
        }
        traverse(original.left,cloned.left,target);
        traverse(original.right,cloned.right,target);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
