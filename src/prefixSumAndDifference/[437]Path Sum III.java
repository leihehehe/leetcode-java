package prefixSumAndDifference;

import binaryTree.TreeNode;

import java.util.HashMap;

class PathSumIIISolution {
    public int pathSum(TreeNode root, int targetSum) {
        map.put(0L, 1);
        dfs(root,0,targetSum);

        return res;
    }
    HashMap<Long,Integer> map = new HashMap<>();
    int res = 0;
    public void dfs(TreeNode root, long sum, int targetSum){
        if(root==null) return;
        sum+= root.val;
        long target = sum-targetSum;
        res+=map.getOrDefault(target, 0);
        map.put(sum, map.getOrDefault(sum, 0)+1);
        dfs(root.left,sum,targetSum);
        dfs(root.right,sum,targetSum);
        map.put(sum,map.get(sum)-1);
    }
}