package binaryTree;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
class MostFrequentSubtreeSum {
    Map<Integer, Integer> map = new HashMap<>();
    private int maxCount = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        getSum(root);
        List<Integer> sums = new ArrayList<>();
        for(int sum : map.keySet()){
            int count = map.get(sum);
            if(count==maxCount){
                sums.add(sum);
            }
        }

        int[] res = new int[sums.size()];
        for(int i =0;i<res.length;i++){
            res[i]=sums.get(i);
        }
        return res;
    }
    public int getSum(TreeNode root){
        if(root==null) return 0;
        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);
        int curSum = leftSum+rightSum+root.val;
        map.put(curSum,map.getOrDefault(curSum,0)+1);
        maxCount = Math.max(maxCount,map.get(curSum));
        return curSum;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
