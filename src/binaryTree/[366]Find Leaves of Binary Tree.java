package binaryTree;
//leetcode submit region begin(Prohibit modification and deletion)


import java.util.LinkedList;
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
class FindLeavesOfBinaryTree {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        getLevel(root);
        return res;
    }
    public int getLevel(TreeNode root){
        if(root==null) return 0;
        int leftLevel = getLevel(root.left);
        int rightLevel = getLevel(root.right);
        int curLevel = Math.max(leftLevel,rightLevel)+1;
        if(res.size()<curLevel){
            res.add(new LinkedList<>());
        }
        res.get(curLevel-1).add(root.val);
        return curLevel;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
