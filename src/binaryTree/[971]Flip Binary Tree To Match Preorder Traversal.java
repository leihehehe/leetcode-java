package binaryTree;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
class FlipBinaryTreeToMatchPreorderTraversal {
    private int index=0;
    private boolean canFlip=true;
    List<Integer> res = new ArrayList<>();
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        traverse(root,voyage);
        if(canFlip) return res;
        return Arrays.asList(-1);
    }
    public void traverse(TreeNode root, int[] voyage){
        if(root==null) return;
        if(root.val!=voyage[index]){
            canFlip=false;
            return;
        }
        index++;
        if(root.left!=null && root.left.val!=voyage[index]){
            TreeNode left = root.left;
            root.left = root.right;
            root.right = left;
            res.add(root.val);
        }
        traverse(root.left,voyage);
        traverse(root.right,voyage);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
