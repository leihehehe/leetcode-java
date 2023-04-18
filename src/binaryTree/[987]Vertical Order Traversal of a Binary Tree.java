package binaryTree;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Collections;
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
class VerticalOrderTraversalOfABinaryTree {
    public List<Triple> path = new ArrayList<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        traverse(root,0,0);
        Collections.sort(path,(Triple a, Triple b)->{
            if(a.col==b.col && a.row == b.row) return a.root.val-b.root.val;
            if(a.col==b.col) return a.row-b.row;
            return a.col-b.col;
        });
        List<List<Integer>> res = new ArrayList<>();
        int lastCol = Integer.MAX_VALUE;
        for(int i =0;i<path.size();i++){
            Triple curTriple = path.get(i);
            if(lastCol!= curTriple.col){
                res.add(new ArrayList<>());
                lastCol = curTriple.col;
            }
            res.get(res.size()-1).add(curTriple.root.val);
        }
        return res;
    }
    public void traverse(TreeNode root,int row, int col){
        if(root==null) return;
        path.add(new Triple(row,col,root));
        traverse(root.left,row+1,col-1);
        traverse(root.right,row+1,col+1);
    }
    class Triple{
        int row;
        int col;
        TreeNode root;
        public Triple(int row, int col, TreeNode root){
            this.row = row;
            this.col = col;
            this.root = root;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
