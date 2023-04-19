package binaryTree;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
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
class PathSumII {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    private int targetSum;
    private int sum=0;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.targetSum=targetSum;
        traverse(root);
        return res;
    }
    public void traverse(TreeNode root){
        if(root==null) return;
        sum+=root.val;
        path.addLast(root.val);
        if(sum==targetSum && root.left==null && root.right==null) res.add(new LinkedList<>(path));
        traverse(root.left);
        traverse(root.right);
        sum-=root.val;
        path.removeLast();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
