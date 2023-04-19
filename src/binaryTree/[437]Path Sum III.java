package binaryTree;
//leetcode submit region begin(Prohibit modification and deletion)


import java.util.HashMap;

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
class PathSumIII {
    private long pathSum = 0L;
    private long targetSum = 0L;
    private int res = 0;
    private HashMap<Long,Integer> map = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        map.put(0L,1);
        this.targetSum=targetSum;
        traverse(root);
        return res;
    }

    public void traverse(TreeNode root){
        if(root==null) return;
        pathSum+=root.val;
        long need = pathSum - targetSum;
        res+=map.getOrDefault(need,0);
        map.put(pathSum,map.getOrDefault(pathSum,0)+1);
        traverse(root.left);
        traverse(root.right);
        map.put(pathSum,map.getOrDefault(pathSum,0)-1);
        pathSum-=root.val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
