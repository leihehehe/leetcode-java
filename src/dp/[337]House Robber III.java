package dp;
//leetcode submit region begin(Prohibit modification and deletion)

import binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

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
class HouseRobberIII {
    Map<TreeNode,Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        return getMaxAmount(root);
    }

    public int getMaxAmount(TreeNode root){
        if(root==null) return 0;
        if(map.containsKey(root)) return map.get(root);
        int rob = 0;
        int notRob = 0;
        //rob
        if(root.left!=null)
            rob+=getMaxAmount(root.left.left) + getMaxAmount(root.left.right);
        if(root.right!=null)
            rob+=getMaxAmount(root.right.left) +getMaxAmount(root.right.right);
        rob+=root.val;

        //not rob
        notRob = getMaxAmount(root.left) + getMaxAmount(root.right);

        int amount = Math.max(rob,notRob);
        map.put(root,amount);
        return amount;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
