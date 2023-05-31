package binaryTree;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashSet;
import java.util.Set;

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
class EqualTreePartition {
    Set<Integer> set = new HashSet<>();
    public boolean checkEqualTree(TreeNode root) {
        int sum = getSum(root.left) + getSum(root.right) + root.val;
        return sum%2 ==0 && set.contains(sum/2);
    }

    public int getSum(TreeNode root){
        if(root==null) return 0;
        int leftSum = getSum(root.left);
        int rightSum= getSum(root.right);
        int sum = leftSum+rightSum+root.val;
        set.add(sum);
        return leftSum+rightSum+root.val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
