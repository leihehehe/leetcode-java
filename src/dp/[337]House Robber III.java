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
class HouseRobberIIIDP{
    public int rob(TreeNode root) {
        int[] res = robHouse(root);
        return Math.max(res[0],res[1]);
    }

    //int[0] -> the maximum amount of not robbing this node
    //int[1] -> the maximum amoutn of robbing this node
    public int[] robHouse(TreeNode root){
        if(root == null)
            return new int[]{0,0};
        int[] robLeft = robHouse(root.left);
        int[] robRight = robHouse(root.right);
        //do not rob this node, its child nodes cannot be robbed
        int rob = root.val +robLeft[0]+robRight[0];
        //do not rob this node, but its child node can be rob and can be not rob.
        int notRob =  Math.max(robLeft[0],robLeft[1])+Math.max(robRight[0],robRight[1]);
        return new int[]{notRob,rob};
    }

}
class HouseRobberIIIDFS {
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
