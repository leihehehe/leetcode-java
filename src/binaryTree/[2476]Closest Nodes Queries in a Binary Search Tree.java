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
class ClosestNodes {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        //bst
        List<Integer> nodes = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        traverse(root, nodes);
        for(int query:queries){
            List<Integer> ans = new ArrayList<>();
            ans.add(-1);
            ans.add(-1);
            int index = binarySearch(nodes, query);
            //min
            int val = nodes.get(index);
            if(val==query){
                ans.set(1, val);
                ans.set(0, val);
            }else if(val>query){
                ans.set(1, val);
                if(index>0){
                    ans.set(0, nodes.get(index-1));
                }
            }else if(val<query){
                ans.set(0, val);
            }

            res.add(ans);
        }
        return res;
    }

    public void traverse(TreeNode root, List<Integer> nodes){
        if(root==null){
            return;
        }
        traverse(root.left, nodes);
        nodes.add(root.val);
        traverse(root.right,nodes);
    }
    //max -> 第一个大于等于query的 -> 返回i-1可以得到最后一个小于等于query的min
    public int binarySearch(List<Integer> nodes, int target){
        int l = 0, r = nodes.size()-1;
        while(l<r){
            int mid = l+r >> 1;
            if(nodes.get(mid)>=target){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
