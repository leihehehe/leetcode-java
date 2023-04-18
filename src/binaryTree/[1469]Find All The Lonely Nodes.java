package binaryTree;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
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
class FindAllTheLonelyNodes {
    private List<Integer> res = new ArrayList<>();
    public List<Integer> getLonelyNodes(TreeNode root) {
        traverse(root);
        return res;
    }
    public void traverse(TreeNode root){
        if(root==null) return;
        if(root.left!=null && root.right==null) res.add(root.left.val);
        if(root.left==null && root.right!=null) res.add(root.right.val);
        traverse(root.left);
        traverse(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
